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
public class DashboardAdminVisitsController {

    private final OrderServiceImpl orderService;
    private final CarServiceImpl carService;
    private final VisitDateServiceImpl visitDateService;

    public DashboardAdminVisitsController(OrderServiceImpl orderService, CarServiceImpl carService, VisitDateServiceImpl visitDateService){
        this.orderService = orderService;
        this.carService = carService;
        this.visitDateService = visitDateService;
    }

    @GetMapping("/dashboard/admin/allVisits")
    public String adminAllVisits (Model model){
        List<Order> usersOrderList = orderService.findAllOrders();
        model.addAttribute("usersOrderList", usersOrderList);

        return "dashboardPages/admin/allVisits";
    }

    @GetMapping("/dashboard/admin/allVisits/details")
    public String viewingAdminSelectedVisit (@RequestParam Integer id, Model model){
        Order selectedVisit = orderService.findOrderById(id);
        model.addAttribute("selectedVisit", selectedVisit);

        return "dashboardPages/admin/visitDetails";
    }

    @PostMapping("/dashboard/admin/allVisits/details")
    public String changeAdminSelectedVisit (@ModelAttribute("selectedVisitId") Integer selectedVisitId, @ModelAttribute("estimatedExecutionTime") Double estimatedExecutionTime, @ModelAttribute("estimatedWorkCost") Integer estimatedWorkCost,
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



        return  "redirect:/dashboard/admin/allVisits/details?success";
    }

    @GetMapping("/dashboard/admin/lastVisits/delete")
    public String viewingAdminConfirmViewDeleteLastVisit (@RequestParam Integer id, Model model){
        Order selectedVisit = orderService.findOrderById(id);
        model.addAttribute("selectedVisit", selectedVisit);
        model.addAttribute("id", id);

        return "dashboardPages/admin/confirmationDeleteLastVisit";
    }

    @PostMapping("/dashboard/admin/lastVisits/delete")
    public String afterAdminConfirmedBoxDeleteLastVisit (Integer id){
        orderService.deleteById(id);

        return "redirect:/dashboard/admin/home?lastVisitDeleteSuccess";
    }

//    @GetMapping("/dashboard/user/visits/delete")
//    public String viewingConfirmViewDeleteVisit (@RequestParam Integer id, Model model){
//        Order selectedVisit = orderService.findOrderById(id);
//        model.addAttribute("selectedVisit", selectedVisit);
//        model.addAttribute("id", id);
//
//        return "dashboardPages/user/confirmationDeleteVisit";
//    }
//
//    @PostMapping("/dashboard/user/visits/delete")
//    public String afterConfirmedBoxDeleteVisit (Integer id){
//        orderService.deleteById(id);
//
//        return "redirect:/dashboard/user/visits?visitDeleteSuccess";
//    }
}
