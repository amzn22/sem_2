package ru.itis.sem1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.sem1.Dto.SignUpDto;
import ru.itis.sem1.Repositories.UserRepository;
import ru.itis.sem1.Services.UserService;

@Controller
public class SignUpController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @GetMapping("/register")
    public String getSignUpPage(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String signUp(SignUpDto signUpDto, Model model) {
        userService.register(signUpDto);
        return "redirect:/login";
    }
}