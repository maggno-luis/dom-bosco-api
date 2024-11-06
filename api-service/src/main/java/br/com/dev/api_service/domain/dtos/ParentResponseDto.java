package br.com.dev.api_service.domain.dtos;

import br.com.dev.api_service.domain.enums.Requested;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentResponseDto {

    private Long id;
    private String name;
    private String email;
    private String cell;
    private String phone;
    private Requested type;

    public ParentResponseDto(String name, String email, String cell, String phone, Requested type) {
        this.name = name;
        this.email = email;
        this.cell = cell;
        this.phone = phone;
        this.type = type;
    }
}
