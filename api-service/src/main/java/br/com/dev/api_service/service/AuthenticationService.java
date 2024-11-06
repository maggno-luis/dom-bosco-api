package br.com.dev.api_service.service;

import br.com.dev.api_service.domain.Role;
import br.com.dev.api_service.domain.User;
import br.com.dev.api_service.domain.dtos.LoginUserDto;
import br.com.dev.api_service.domain.dtos.RegisterUserDto;
import br.com.dev.api_service.domain.enums.RoleEnum;
import br.com.dev.api_service.exceptions.EmailExistException;
import br.com.dev.api_service.exceptions.EmailInvalidException;
import br.com.dev.api_service.exceptions.PasswordInvalidException;
import br.com.dev.api_service.repository.RoleRepository;
import br.com.dev.api_service.repository.UserRepository;
import br.com.dev.api_service.utils.EmailValidator;
import br.com.dev.api_service.utils.PasswordValidator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleRepository roleRepository;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder, RoleRepository roleRepository
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public User signup(RegisterUserDto input) {
        Optional<Role> optionalRole = roleRepository.findByName(RoleEnum.USER);

        if (optionalRole.isEmpty()) {
            return null;
        }
        userRepository.findByEmail(input.getEmail()).ifPresent(user -> {
            throw new EmailExistException("Email já está em uso");
        });
        var validateEmail = EmailValidator.isValidEmail(input.getEmail());
        if (!validateEmail){
            throw new EmailInvalidException("Digite um email válido");
        }
        var validatePassword = PasswordValidator.isValidPassword(input.getPassword());
        if (!validatePassword){
            throw new PasswordInvalidException("Digite uma senha válida, maior que 8 digitos com letras e números");
        }

        User user = new User();
        user.setFullName(input.getName());
        user.setEmail(input.getEmail());
        user.setRole(optionalRole.get());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword())
        );

        var auth = userRepository.findByEmail(input.getEmail()).orElseThrow(
                ()-> new UsernameNotFoundException("Email ou senha incorretos")
        );
        return auth;
    }
}
