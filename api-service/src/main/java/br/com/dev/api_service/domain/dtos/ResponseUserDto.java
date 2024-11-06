package br.com.dev.api_service.domain.dtos;

import br.com.dev.api_service.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ResponseUserDto {
    private UUID id;
    private String name;
    private String email;
    private String password;
    private Date createAt;

    public ResponseUserDto(UUID id, String username, String email, Date createdAt) {
        this.id = id;
        this.name = username;
        this.email = email;
        this.createAt = createdAt;
    }

    public ResponseUserDto(User userSaved) {
        this.id = userSaved.getId();
        this.name = userSaved.getFullName();
        this.email = userSaved.getEmail();
        this.createAt = userSaved.getCreatedAt();
    }
}
