package br.com.dev.api_service.domain.dtos;

import br.com.dev.api_service.domain.Called;
import br.com.dev.api_service.domain.Student;
import br.com.dev.api_service.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalledResponseDto {
    
    private Long id;
    private String questions;
    private String observationForSchool;
    private String provisions;
    private String finalObservations;
    private LocalDateTime dateOfAttendance;

    @ManyToOne
    private Student student;

    private String user;
    private Status status;
    public CalledResponseDto(Called calledSaved) {
        this.id = calledSaved.getId();
        this.questions = calledSaved.getQuestions();
        this.observationForSchool = calledSaved.getObservationForSchool();
        this.provisions = calledSaved.getProvisions();
        this.finalObservations = calledSaved.getFinalObservations();
        this.dateOfAttendance = calledSaved.getDateOfAttendance();
        this.student = calledSaved.getStudent();
        this.user = calledSaved.getUser();
        this.status = calledSaved.getStatus();
    }

}

