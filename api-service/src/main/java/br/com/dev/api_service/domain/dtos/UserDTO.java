package br.com.dev.api_service.domain.dtos;

import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastName;
}
