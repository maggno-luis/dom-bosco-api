package br.com.dev.api_service.websocket.user;

import br.com.dev.api_service.websocket.dtos.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String nickName;
    private String fullName;
    private Status status;
}
