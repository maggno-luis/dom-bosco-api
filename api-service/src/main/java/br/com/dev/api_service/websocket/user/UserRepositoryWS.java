package br.com.dev.api_service.websocket.user;

import br.com.dev.api_service.websocket.dtos.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepositoryWS extends MongoRepository<User, String> {

    List<User> findAllByStatus(Status status);
}
