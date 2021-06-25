package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rasilewicz.car_workshop_manager.entities.User;
import pl.rasilewicz.car_workshop_manager.services.UserServiceImpl;
import java.util.List;

@Controller
public class DashboardAdminUsersController {

    private final UserServiceImpl userService;

    public DashboardAdminUsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/dashboard/admin/users")
    public String AdminProfile (Model model){
        List<User> userList = userService.
        model.addAttribute("userProfile", userProfile);

        String newPassword = "";
        model.addAttribute("newPassword", newPassword);

        return "dashboardPages/admin/adminProfile";
    }
}
