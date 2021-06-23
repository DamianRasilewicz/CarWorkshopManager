package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rasilewicz.car_workshop_manager.entities.Role;
import pl.rasilewicz.car_workshop_manager.entities.User;
import pl.rasilewicz.car_workshop_manager.services.RoleServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.UserServiceImpl;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardUserProfileController {

    private final UserServiceImpl userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleServiceImpl roleService;

    public DashboardUserProfileController(UserServiceImpl userService, BCryptPasswordEncoder bCryptPasswordEncoder, RoleServiceImpl roleService){
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleService = roleService;
    }

    @GetMapping("/dashboard/user/profile")
    public String userProfile (Model model, HttpSession session){
        User userProfile = userService.findUserById((Integer)session.getAttribute("userId"));
        model.addAttribute("userProfile", userProfile);

        String newPassword = "";
        model.addAttribute("newPassword", newPassword);

        return "dashboardPages/user/userProfile";
    }

    @PostMapping("/dashboard/user/profile")
    public String changedUserProfile (User userProfile, String newPassword, HttpSession session){

        if (!newPassword.equals("")){
            userProfile.setPassword(bCryptPasswordEncoder.encode(newPassword));
        } else {
            userProfile.setPassword(userProfile.getPassword());
        }
        Role userRole = roleService.findRoleByName("USER");
        userProfile.setRole(userRole);
        userService.save(userProfile);

        session.removeAttribute("userName");
        session.setAttribute("userName", userProfile.getUserName());

        return "redirect:/dashboard/user/profile?success";
    }
}
