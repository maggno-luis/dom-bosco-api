package br.com.dev.api_service.service;

import br.com.dev.api_service.domain.Called;
import br.com.dev.api_service.domain.dtos.CalledResponseDto;
import br.com.dev.api_service.domain.User;
import br.com.dev.api_service.domain.dtos.*;
import br.com.dev.api_service.domain.enums.Status;
import br.com.dev.api_service.mapper.*;
import br.com.dev.api_service.repository.CalledRepository;
import br.com.dev.api_service.repository.ParentRepository;
import br.com.dev.api_service.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalledService {

    private final CalledRepository calledRepository;
    private final StudentRepository studentRepository;
    private final ParentRepository parentRepository;
    private final StudentMapper studentMapper;
    private final ParentMapper parentMapper;
    private final CalledMapper calledMapper;

    @Autowired
    public CalledService(CalledRepository calledRepository, StudentRepository studentRepository,
                         ParentRepository parentRepository, StudentMapper studentMapper,
                         ParentMapper parentMapper, CalledMapper calledMapper ) {
        this.calledRepository = calledRepository;
        this.studentRepository = studentRepository;
        this.parentRepository = parentRepository;
        this.studentMapper = studentMapper;
        this.parentMapper = parentMapper;
        this.calledMapper = calledMapper;
    }

    public CalledResponseDto create(CreateCallRequestDto requestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        var parentSaved = parentRepository.save(parentMapper.toParent(requestDto));
        var studentSaved = studentRepository.save(studentMapper.toStudent(requestDto, parentSaved));
        var calledSaved = calledRepository.save(calledMapper.toCalled(requestDto, studentSaved, username));
        return new CalledResponseDto(calledSaved);
    }
    public Page<CalledResponseDto> listAll(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Called> calledPage = this.calledRepository.findAll(pageable);
        return calledPage.map(MapToDto::toDto);
    }

    public Page<CalledResponseDto> listMyCalling(String email, int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        Page<Called> calledPage = this.calledRepository.findAllByUserEmail(email, pageable);
        return calledPage.map(MapToDto::toDto);
    }

    public CalledResponseDto updateCallStatus(Long id){
        Called called = calledRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Chamado não existe: " + id));
        called.setStatus(Status.RESOLVIDO);
        var update = calledRepository.save(called);
        return new CalledResponseDto(update);
    }

}