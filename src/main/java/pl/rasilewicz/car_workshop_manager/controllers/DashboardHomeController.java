package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.rasilewicz.car_workshop_manager.entities.Order;
import pl.rasilewicz.car_workshop_manager.services.MechanicServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.OrderServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.UserServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.VisitDateServiceImpl;

import java.time.LocalDate;
import java.util.*;

import javax.servlet.http.HttpSession;

@Controller
public class DashboardHomeController {

    private final OrderServiceImpl orderService;
    private final VisitDateServiceImpl visitDateService;
    private final UserServiceImpl userService;
    private final MechanicServiceImpl mechanicService;

    public DashboardHomeController(OrderServiceImpl orderService, VisitDateServiceImpl visitDateService, UserServiceImpl userService,
                                   MechanicServiceImpl mechanicService) {
        this.orderService = orderService;
        this.visitDateService = visitDateService;
        this.userService = userService;
        this.mechanicService = mechanicService;
    }

    @GetMapping("/dashboard/user/home")
    public String userHome(Model model, HttpSession session) {
        List<Order> userLastOrderList = orderService.findLastOrdersByUserId((Integer) session.getAttribute("userId"));
        model.addAttribute("userOrderList", userLastOrderList);

        Integer userId = (Integer) session.getAttribute("userId");

        List<String> monthsList = Arrays.asList("January", "February", "March", "April", "Mai", "June", "July",
                "August", "September", "October", "November", "December");

        Map<String, Integer> dataVisitsChart = new LinkedHashMap<String, Integer>();

        for (int i = 0; i < monthsList.size(); i++) {
            dataVisitsChart.put(monthsList.get(i), visitDateService.findNumberOfVisitDatesByMonthByUserId(i + 1, userId));
        }


        model.addAttribute("dataVisitsChart", dataVisitsChart);


        return "dashboardPages/user/dashboard";
    }

    @GetMapping("/dashboard/admin/home")
    public String adminIndex(Model model, HttpSession session) {
        List<Order> usersLastOrderList = orderService.findLastUsersOrders();
        model.addAttribute("usersOrderList", usersLastOrderList);

        List<String> monthsList = Arrays.asList("January", "February", "March", "April", "Mai", "June", "July",
                "August", "September", "October", "November", "December");

        Map<String, Integer> dataVisitsChart = new LinkedHashMap<String, Integer>();
        Map<String, Integer> dataRevenuesChart = new LinkedHashMap<String, Integer>();

        Integer presentYear = LocalDate.now().getYear();

        for (int i = 0; i < monthsList.size(); i++) {
            dataVisitsChart.put(monthsList.get(i), visitDateService.findNumberOfVisitDatesAllUsersOfYear(i + 1, presentYear));
            if (orderService.findMonthlyRevenue(i + 1, presentYear) == null){
                dataRevenuesChart.put(monthsList.get(i), 0);
            } else {
                dataRevenuesChart.put(monthsList.get(i), orderService.findMonthlyRevenue(i + 1, presentYear));
            }

        }

        model.addAttribute("dataVisitsChart", dataVisitsChart);
        model.addAttribute("dataRevenuesChart", dataRevenuesChart);
        model.addAttribute("presentYear", presentYear);

        List<Order> threeUndoneOrderList = orderService.findThreeUndoneOrders();
        model.addAttribute("threeUndoneOrderList", threeUndoneOrderList);

        List<Order> undoneOrderList = orderService.findAllUndoneOrders();
        Integer numberOfUndoneOrders = undoneOrderList.size();
        model.addAttribute("numberOfUndoneOrders", numberOfUndoneOrders);

        Integer numberOfAllOrders = orderService.findNumberOfAllOrders();
        model.addAttribute("numberOfAllOrders", numberOfAllOrders);

        Integer numberOfAllUsers = userService.findNumberOfAllUsers();
        model.addAttribute("numberOfAllUsers", numberOfAllUsers);

        Integer totalRevenue = orderService.findTotalRevenue();
        model.addAttribute("totalRevenue", totalRevenue);

        Integer numberOfAllMechanics = mechanicService.findNumberOfMechanics();
        model.addAttribute("numberOfAllMechanics", numberOfAllMechanics);

        return "dashboardPages/admin/dashboard";

    }
}
