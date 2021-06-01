package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rasilewicz.car_workshop_manager.entities.Order;
import pl.rasilewicz.car_workshop_manager.services.OrderServiceImpl;
import java.util.List;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardHomeController {

    private final OrderServiceImpl orderService;

    public DashboardHomeController(OrderServiceImpl orderService){
        this.orderService = orderService;
    }

    @GetMapping("/dashboard/user/home")
    public String index(Model model, HttpSession session){
        List<Order> userLastOrderList = orderService.findLastOrdersByUserId((Integer)session.getAttribute("userId"));
        model.addAttribute("userOrderList", userLastOrderList);

        return "dashboardPages/dashboard";
    }

}
