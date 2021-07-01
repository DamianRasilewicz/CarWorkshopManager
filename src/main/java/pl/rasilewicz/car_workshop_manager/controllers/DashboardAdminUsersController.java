package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rasilewicz.car_workshop_manager.entities.Order;
import pl.rasilewicz.car_workshop_manager.entities.Role;
import pl.rasilewicz.car_workshop_manager.entities.User;
import pl.rasilewicz.car_workshop_manager.services.OrderServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.RoleServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.UserServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

@Controller
public class DashboardAdminUsersController {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;
    private final OrderServiceImpl orderService;

    public DashboardAdminUsersController(UserServiceImpl userService, RoleServiceImpl roleService, OrderServiceImpl orderService) {
        this.userService = userService;
        this.roleService = roleService;
        this.orderService = orderService;
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

        List<Role> roleList = roleService.findAllRoles();
        model.addAttribute("roleList", roleList);

        List<Boolean> enabledList = Arrays.asList(true, false);
        model.addAttribute("enabledList", enabledList);

        return "dashboardPages/admin/userEdit";
    }

    @PostMapping("/dashboard/admin/users/edit")
    public String userDetailsChanged (@ModelAttribute("selectedUserId") Integer selectedUserId, @ModelAttribute("newRole") String newRole,
                                      @ModelAttribute("newEnabled") Boolean newEnabled, @RequestParam("role") Integer roleId, RedirectAttributes redirectAttributes){

        User editedUser = userService.findUserById(selectedUserId);

        Role selectedRole = roleService.findRoleById(roleId);

        editedUser.setRole(selectedRole);
        editedUser.setEnabled(newEnabled);
        userService.save(editedUser);

        redirectAttributes.addAttribute("id", selectedUserId);

        return "redirect:/dashboard/admin/users/edit?success";
    }

    @GetMapping("/dashboard/admin/users/userVisitList")
    public String userVisitList(Model model){

        List<User> userList = userService.findAllUsers();
        model.addAttribute("userList", userList);

        return "dashboardPages/admin/userVisitListAllUsers";
    }

    @GetMapping("/dashboard/admin/users/userVisitList/show")
    public String selectedUserVisitList(@RequestParam Integer userId, Model model){

        List<Order> userOrderList = orderService.findOrdersByUserId(userId);
        model.addAttribute("userOrderList", userOrderList);

        model.addAttribute("userName", userService.findUserById(userId).getUserName());


        return "dashboardPages/admin/userVisitListSelectedUser";
    }

    @GetMapping("/dashboard/admin/users/userVisitDetails")
    public String selectedUserVisitDetails(@RequestParam Integer id, Model model){

        Order selectedOrderDetails = orderService.findOrderById(id);
        model.addAttribute("selectedOrderDetails", selectedOrderDetails);

        return "dashboardPages/admin/selectedUserVisitDetails";
    }

    @PostMapping("/dashboard/admin/users/userVisitDetails")
    public String selectedUserVisitEdited (@ModelAttribute("selectedVisitId") Integer selectedVisitId, @ModelAttribute("estimatedExecutionTime") Double estimatedExecutionTime, @ModelAttribute("estimatedWorkCost") Integer estimatedWorkCost,
                                            @ModelAttribute("workingHours") Integer workingHours, @ModelAttribute("workCost") Double workCost, @ModelAttribute("partsCost") Double partsCost,
                                            @ModelAttribute("finalCost") Double finalCost, @ModelAttribute("moreInformation") String moreInformation, @ModelAttribute("wroteComment") String wroteComment,
                                            @ModelAttribute("status") String status, RedirectAttributes redirectAttributes){

        Order selectedVisit = orderService.findOrderById(selectedVisitId);
        selectedVisit.setEstimatedExecutionTime(estimatedExecutionTime);
        selectedVisit.setEstimatedWorkCost(estimatedWorkCost);
        selectedVisit.setWorkingHours(workingHours);
        selectedVisit.setWorkCost(workCost);
        selectedVisit.setPartsCost(partsCost);
        selectedVisit.setFinalCost(finalCost);
        selectedVisit.setMoreInformation(moreInformation);
        selectedVisit.setComment(wroteComment);
        selectedVisit.setStatus(status);
        orderService.save(selectedVisit);


        redirectAttributes.addAttribute("id", selectedVisit.getId());



        return  "redirect:/dashboard/admin/users/userVisitDetails?success";
    }
}
