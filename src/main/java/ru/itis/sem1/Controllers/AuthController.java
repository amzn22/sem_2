package ru.itis.sem1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.sem1.Services.AuthCheckService;

@Controller
public class AuthController {

    @Autowired
    private AuthCheckService authCheckService;

    @GetMapping("/auth")
    public String authPage(@RequestParam String uuid, Model model){
        authCheckService.checkAuth(uuid);
        return "redirect:/login";
    }
}