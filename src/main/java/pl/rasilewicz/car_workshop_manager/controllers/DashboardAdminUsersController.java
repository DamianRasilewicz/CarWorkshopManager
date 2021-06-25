package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rasilewicz.car_workshop_manager.entities.Role;
import pl.rasilewicz.car_workshop_manager.entities.User;
import pl.rasilewicz.car_workshop_manager.services.RoleServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.UserServiceImpl;
import java.util.List;

@Controller
public class DashboardAdminUsersController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public DashboardAdminUsersController(UserServiceImpl userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/dashboard/admin/users")
    public String userList (Model model){
        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList", userList);

        return "dashboardPages/admin/users";
    }

    @GetMapping("/dashboard/admin/users/edit")
    public String userDetails (@RequestParam Integer id, Model model){
        User user = userService.findUserById(id);
        model.addAttribute("user", user);

        return "dashboardPages/admin/userEdit";
    }

    @PostMapping("/dashboard/admin/users/edit")
    public String userDetailsChanged (@ModelAttribute("selectedUserId") Integer selectedUserId, @ModelAttribute("newRole") String newRole,
                                      @ModelAttribute("newEnabled") Boolean newEnabled, RedirectAttributes redirectAttributes){

        User editedUser = userService.findUserById(selectedUserId);

        Role selectedRole = roleService.findRoleByName(newRole);

        editedUser.setRole(selectedRole);
        editedUser.setEnabled(newEnabled);
        userService.save(editedUser);

        redirectAttributes.addAttribute("id", selectedUserId);

        return "redirect:/dashboard/admin/users/edit?success";
    }
}
