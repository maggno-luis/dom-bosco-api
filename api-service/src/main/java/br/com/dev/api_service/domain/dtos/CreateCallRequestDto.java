package br.com.dev.api_service.domain.dtos;

import br.com.dev.api_service.domain.Parent;
import br.com.dev.api_service.domain.User;
import br.com.dev.api_service.domain.enums.Requested;
import br.com.dev.api_service.domain.Student;
import br.com.dev.api_service.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCallRequestDto {

    private String nameParent;
    private String emailParent;
    private String cellParent;
    private String phoneParent;
    private Requested type;

    private String nameStudent;
    private LocalDateTime dateOfBirth;
    private Integer classNumber;
    private Integer grade;
    private Parent parent;

    private String questions;
    private String observationForSchool;
    private String provisions;
    private String finalObservations;
    private Student student;

    private String user;
    private Status status;

}
