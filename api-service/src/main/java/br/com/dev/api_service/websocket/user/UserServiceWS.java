package br.com.dev.api_service.websocket.user;

import br.com.dev.api_service.websocket.dtos.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceWS {

    private final UserRepositoryWS userRepositoryWS;

    public void saveUser(User user){
        user.setStatus(Status.ONLINE);
        userRepositoryWS.save(user);
    }

    public void disconnect(User user) {
        var storedUser = userRepositoryWS.findById(user.getNickName()).orElse(null);
        if (storedUser != null) {
            storedUser.setStatus(Status.OFFLINE);
            userRepositoryWS.save(storedUser);
        }
    }

    public List<User> findConnectedUsers() {
        return userRepositoryWS.findAllByStatus(Status.ONLINE);
    }
}
