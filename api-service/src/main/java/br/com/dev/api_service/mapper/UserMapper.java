package br.com.dev.api_service.mapper;

import br.com.dev.api_service.domain.User;
import br.com.dev.api_service.domain.dtos.RegisterUserDto;
import br.com.dev.api_service.domain.dtos.ResponseUserDto;

public class UserMapper {

    public User toUser(RegisterUserDto registerUserDto){
        return new User(
                registerUserDto.getName(),
                registerUserDto.getEmail(),
                registerUserDto.getPassword(),
                registerUserDto.getCreateAt()
        );
    }

    public static ResponseUserDto toDto(User user){
        return new ResponseUserDto(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt()
        );
    }
}
