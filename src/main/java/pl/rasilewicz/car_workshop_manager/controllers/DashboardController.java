package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rasilewicz.car_workshop_manager.entities.Order;
import pl.rasilewicz.car_workshop_manager.services.OrderServiceImpl;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardController {

    private final OrderServiceImpl orderService;

    public DashboardController(OrderServiceImpl orderService){
        this.orderService = orderService;
    }

    @GetMapping("/dashboard/user/home")
    public String index(Model model, HttpSession session){
        List<Order> userOrderList = orderService.findOrderByUserId((Integer)session.getAttribute("userId"));
        model.addAttribute("userOrderList", userOrderList);

        return "dashboardPages/dashboard";
    }
}
