package br.com.dev.api_service.domain.dtos;

import br.com.dev.api_service.domain.Parent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StudentResponseDto {

    private Long id;
    private String name;
    private LocalDateTime dateOfBirth;
    private Integer classNumber;
    private Integer grade;
    private Parent parent;
}
