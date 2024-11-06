package br.com.dev.api_service.domain.dtos;

import br.com.dev.api_service.domain.Parent;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StudentDto {

    private String name;
    private LocalDateTime dateOfBirth;
    private Integer classNumber;
    private Integer grade;
    private LocalDateTime dateOfAttendance;
}
