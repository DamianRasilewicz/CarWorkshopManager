package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rasilewicz.car_workshop_manager.entities.Order;
import pl.rasilewicz.car_workshop_manager.services.CarServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.OrderServiceImpl;
import pl.rasilewicz.car_workshop_manager.services.VisitDateServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class DashboardVisitsController {

    private final OrderServiceImpl orderService;
    private final CarServiceImpl carService;
    private final VisitDateServiceImpl visitDateService;

    public DashboardVisitsController(OrderServiceImpl orderService, CarServiceImpl carService, VisitDateServiceImpl visitDateService){
        this.orderService = orderService;
        this.carService = carService;
        this.visitDateService = visitDateService;
    }

    @GetMapping("/dashboard/user/visits")
    public String userVisits (Model model, HttpSession session){
        List<Order> userOrderList = orderService.findOrdersByUserId((Integer)session.getAttribute("userId"));
        model.addAttribute("userOrderList", userOrderList);

        return "dashboardPages/user/visits";
    }

    @GetMapping("/dashboard/user/visits/details")
    public String viewingSelectedVisit (@RequestParam Integer id, Model model){
        Order selectedVisit = orderService.findOrderById(id);
        model.addAttribute("selectedVisit", selectedVisit);

        return "dashboardPages/user/visitDetails";
    }

    @PostMapping("/dashboard/user/visits/details")
    public String changedSelectedVisit (@ModelAttribute("selectedVisitId") Integer selectedVisitId, @ModelAttribute("wroteComment") String wroteComment,
                                        @ModelAttribute("visitDateId") Integer visitDateId, @ModelAttribute("carId") Integer carId, RedirectAttributes redirectAttributes) {

        Order selectedVisit = orderService.findOrderById(selectedVisitId);

        selectedVisit.setCar(carService.findCarById(carId));
        selectedVisit.setVisitDate(visitDateService.findVisitDateById(visitDateId));
        selectedVisit.setComment(wroteComment);
        orderService.save(selectedVisit);


        redirectAttributes.addAttribute("id", selectedVisit.getId());



        return  "redirect:/dashboard/user/visits/details?success";
    }

    @GetMapping("/dashboard/user/lastVisits/delete")
    public String viewingConfirmViewDeleteLastVisit (@RequestParam Integer id, Model model){
        Order selectedVisit = orderService.findOrderById(id);
        model.addAttribute("selectedVisit", selectedVisit);
        model.addAttribute("id", id);

        return "dashboardPages/user/confirmationDeleteLastVisit";
    }

    @PostMapping("/dashboard/user/lastVisits/delete")
    public String afterConfirmedBoxDeleteLastVisit (Integer id){
        orderService.deleteById(id);

        return "redirect:/dashboard/user/home?lastVisitDeleteSuccess";
    }

    @GetMapping("/dashboard/user/visits/delete")
    public String viewingConfirmViewDeleteVisit (@RequestParam Integer id, Model model){
        Order selectedVisit = orderService.findOrderById(id);
        model.addAttribute("selectedVisit", selectedVisit);
        model.addAttribute("id", id);

        return "dashboardPages/user/confirmationDeleteVisit";
    }

    @PostMapping("/dashboard/user/visits/delete")
    public String afterConfirmedBoxDeleteVisit (Integer id){
        orderService.deleteById(id);

        return "redirect:/dashboard/user/visits?visitDeleteSuccess";
    }
}
