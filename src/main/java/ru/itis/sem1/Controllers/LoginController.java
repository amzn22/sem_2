package ru.itis.sem1.Controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {

    @GetMapping(path={"/", "/login"})
    public String getLoginPage() {
        return "login";
    }
}
