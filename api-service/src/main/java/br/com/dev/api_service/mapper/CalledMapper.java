package br.com.dev.api_service.mapper;

import br.com.dev.api_service.domain.Called;
import br.com.dev.api_service.domain.Student;
import br.com.dev.api_service.domain.dtos.CreateCallRequestDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CalledMapper {
    public Called toCalled(CreateCallRequestDto requestDto,
                           Student studentSaved, String user) {
        Called called = new Called();
        called.setQuestions(requestDto.getQuestions());
        called.setObservationForSchool(requestDto.getObservationForSchool());
        called.setProvisions(requestDto.getProvisions());
        called.setFinalObservations(requestDto.getFinalObservations());
        called.setDateOfAttendance(LocalDateTime.now());
        called.setStudent(studentSaved);
        called.setUser(user);
        called.setStatus(requestDto.getStatus());
        return called;
    }
}
