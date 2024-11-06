package br.com.dev.api_service.domain.dtos;

import lombok.Data;

@Data
public class LoginUserDto {
    private String email;
    private String password;
}
