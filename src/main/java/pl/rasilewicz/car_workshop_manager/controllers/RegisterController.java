package pl.rasilewicz.car_workshop_manager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rasilewicz.car_workshop_manager.entities.User;

@Controller
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/registration")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "registrationPage/registrationForm";
    }

    @PostMapping("/registration")
    public String registerFormFilled(Model model){


        return "registrationPage/registrationForm";
    }
}
