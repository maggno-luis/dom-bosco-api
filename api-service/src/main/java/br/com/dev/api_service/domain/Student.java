package br.com.dev.api_service.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime dateOfBirth;
    private Integer classNumber;
    private Integer grade;
    @ManyToOne(fetch = FetchType.EAGER)
    private Parent parent;

    public Student(String name, LocalDateTime dateOfBirth, Integer classNumber, Integer grade, Parent parent) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.classNumber = classNumber;
        this.grade = grade;
        this.parent = parent;
    }
}
