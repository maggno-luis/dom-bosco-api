package br.com.dev.api_service.domain.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class RegisterUserDto {
    private String name;
    private String email;
    private String password;
    private String role;
    private Date createAt;
}
