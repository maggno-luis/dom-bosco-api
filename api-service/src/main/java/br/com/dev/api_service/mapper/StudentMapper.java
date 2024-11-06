package br.com.dev.api_service.mapper;

import br.com.dev.api_service.domain.Parent;
import br.com.dev.api_service.domain.Student;
import br.com.dev.api_service.domain.dtos.CreateCallRequestDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toStudent(CreateCallRequestDto requestDto,
                             Parent parentSaved){
        Student student = new Student();
        student.setName(requestDto.getNameStudent());
        student.setDateOfBirth(requestDto.getDateOfBirth());
        student.setClassNumber(requestDto.getClassNumber());
        student.setGrade(requestDto.getGrade());
        student.setParent(parentSaved);
        return student;
    }
}
