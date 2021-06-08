package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.rasilewicz.car_workshop_manager.entities.Car;
import pl.rasilewicz.car_workshop_manager.entities.User;
import pl.rasilewicz.car_workshop_manager.services.CarServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.UserServiceImpl;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardUserCarsController {

    private final UserServiceImpl userService;
    private final CarServiceImpl carService;

    public DashboardUserCarsController(UserServiceImpl userService, CarServiceImpl carService){
        this.userService = userService;
        this.carService = carService;
    }

    @GetMapping("/dashboard/user/cars")
    public String userCarsList (Model model, HttpSession session){
        List<Car> userCarList = carService.findCarsByUserId((Integer)session.getAttribute("userId"));
        model.addAttribute("userCarList", userCarList);

        return "dashboardPages/cars";
    }

    @PostMapping("/dashboard/user/cars")
    public String changedUserProfile (User userProfile, String newPassword, HttpSession session){

        session.removeAttribute("userName");
        session.setAttribute("userName", userProfile.getUserName());

        return "redirect:/dashboard/user/profile?success";
    }
}
