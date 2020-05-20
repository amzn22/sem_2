package ru.itis.sem1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping(path="/adminpanel")
    public String getAdminPage() {
        return "adminpanel";
    }
}
