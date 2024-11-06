package br.com.dev.api_service.domain;

import br.com.dev.api_service.domain.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Called {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questions;
    private String observationForSchool;
    private String provisions;
    private String finalObservations;
    private LocalDateTime dateOfAttendance;

    @ManyToOne
    private Student student;

    private String user;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Called(String questions, String observationForSchool, String provisions,
                  String finalObservations, Student student, LocalDateTime dateOfAttendance, String user) {
        this.questions = questions;
        this.observationForSchool = observationForSchool;
        this.provisions = provisions;
        this.finalObservations = finalObservations;
        this.student = student;
        this.dateOfAttendance = dateOfAttendance;
        this.user = user;
    }

    public Called(String questions, String observationForSchool, String provisions, String finalObservations, Parent parent) {
        this.questions = questions;
        this.observationForSchool = observationForSchool;
        this.provisions = provisions;
        this.finalObservations = finalObservations;
    }
}

