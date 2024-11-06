package br.com.dev.api_service.domain.dtos;

import br.com.dev.api_service.domain.enums.Requested;
import br.com.dev.api_service.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {

    private String nameParent;
    private String emailParent;
    private String cellParent;
    private String phoneParent;
    private Requested type;

    private String nameStudent;
    private LocalDateTime dateOfBirth;
    private Integer classNumber;
    private Integer grade;

    private String questions;
    private String observationForSchool;
    private String provisions;
    private String finalObservations;
    private Student student;
    private LocalDateTime dateOfAttendance;

    @Data
    public static class StudentDto {

        private Long id;
        private String name;
        private LocalDateTime dateOfBirth;
        private Integer classNumber;
        private Integer grade;
        private LocalDateTime dateOfAttendance;

    }

    @Data
    public static class ParentDto {

        private Long id;
        private String name;
        private String email;
        private String cell;
        private String phone;
        private Requested type;
    }
}
