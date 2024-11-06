package br.com.dev.api_service.domain;

import br.com.dev.api_service.domain.enums.Requested;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Parent{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cell;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Requested type;

    public Parent(String name, String email, String cell, String phone, Requested type) {
        this.name = name;
        this.email = email;
        this.cell = cell;
        this.phone = phone;
        this.type = type;
    }
}
