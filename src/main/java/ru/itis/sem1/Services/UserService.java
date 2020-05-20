package ru.itis.sem1.Services;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.itis.sem1.Dto.SignUpDto;

@Service
public interface UserService {
    public void register(SignUpDto signUpDto);
}