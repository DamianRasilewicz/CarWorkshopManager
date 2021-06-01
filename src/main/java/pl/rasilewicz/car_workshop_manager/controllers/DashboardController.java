package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rasilewicz.car_workshop_manager.entities.User;

@Controller
public class DashboardController {

    @GetMapping("/dashboard/user/home")
    public String index(Model model){

        return "dashboardPages/dashboard";
    }
}
