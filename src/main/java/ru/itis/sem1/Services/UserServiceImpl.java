package ru.itis.sem1.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.sem1.Dto.SignUpDto;
import ru.itis.sem1.Models.Role;
import ru.itis.sem1.Models.State;
import ru.itis.sem1.Models.User;
import ru.itis.sem1.Repositories.UserRepository;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MailSenderService mailSenderService;

    @Override
    public void register(SignUpDto signUpDto) {

        User user = User.builder()
                .email(signUpDto.getEmail())
                .password(passwordEncoder.encode(signUpDto.getPassword()))
                .name(signUpDto.name)
                .role(Role.USER)
                .state(State.NOT_CONFIRMED)
                .uuid(UUID.randomUUID().toString())
                .build();
        mailSenderService.sendMail(user);
        userRepository.save(user);
    }
}