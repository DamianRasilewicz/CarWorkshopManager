package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.rasilewicz.car_workshop_manager.entities.Order;
import pl.rasilewicz.car_workshop_manager.services.OrderServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DashboardVisitsController {

    private final OrderServiceImpl orderService;

    public DashboardVisitsController(OrderServiceImpl orderService){
        this.orderService = orderService;
    }

    @GetMapping("/dashboard/user/visits")
    public String userVisits (Model model, HttpSession session){
        List<Order> userOrderList = orderService.findOrdersByUserId((Integer)session.getAttribute("userId"));
        model.addAttribute("userOrderList", userOrderList);

        return "dashboardPages/visits";
    }

    @GetMapping("/dashboard/user/visits/details")
    public String viewingSelectedVisit (@RequestParam Integer id, Model model){
        Order selectedVisit = orderService.findOrderById(id);
        model.addAttribute("selectedVisit", selectedVisit);


        return "dashboardPages/visitDetails";
    }
}
