package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rasilewicz.car_workshop_manager.entities.Order;
import pl.rasilewicz.car_workshop_manager.services.OrderServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.VisitDateServiceImpl;

import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardHomeController {

    private final OrderServiceImpl orderService;
    private final VisitDateServiceImpl visitDateService;

    public DashboardHomeController(OrderServiceImpl orderService, VisitDateServiceImpl visitDateService){
        this.orderService = orderService;
        this.visitDateService = visitDateService;
    }

    @GetMapping("/dashboard/user/home")
    public String userHome(Model model, HttpSession session){
        List<Order> userLastOrderList = orderService.findLastOrdersByUserId((Integer)session.getAttribute("userId"));
        model.addAttribute("userOrderList", userLastOrderList);

        Integer userId = (Integer)session.getAttribute("userId");

        List<String> monthsList = Arrays.asList("January", "February", "March", "April", "Mai", "June", "July",
                                                "August", "September", "October", "November", "December");

        Map<String, Integer> data = new LinkedHashMap<String, Integer>();

        for (int i = 0; i <monthsList.size() ; i++) {
            data.put(monthsList.get(i), visitDateService.findNumberOfVisitDatesByMonthByUserId(i + 1,userId));
        }


        model.addAttribute("data", data);


        return "dashboardPages/dashboard";
    }

    @GetMapping("/dashboard/admin/home")
    public String adminIndex(Model model, HttpSession session){
        List<Order> usersLastOrderList = orderService.findLastUsersOrders();
        model.addAttribute("usersOrderList", usersLastOrderList);

        Integer userId = (Integer)session.getAttribute("userId");

        List<String> monthsList = Arrays.asList("January", "February", "March", "April", "Mai", "June", "July",
                "August", "September", "October", "November", "December");

        Map<String, Integer> data = new LinkedHashMap<String, Integer>();

        for (int i = 0; i <monthsList.size() ; i++) {
            data.put(monthsList.get(i), visitDateService.findNumberOfVisitDatesByMonthByUserId(i + 1,userId));
        }


        model.addAttribute("data", data);


        return "dashboardPages/dashboard";

}
