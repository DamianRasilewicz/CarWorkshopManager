package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rasilewicz.car_workshop_manager.entities.*;
import pl.rasilewicz.car_workshop_manager.services.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainPageController {

    private final TaskServiceImpl taskService;
    private final WorkshopServiceImpl workshopService;
    private final VisitDateServiceImpl visitDateService;
    private final OrderServiceImpl orderService;
    private final UserServiceImpl userService;
    private final CarServiceImpl carService;
    private final RoleServiceImpl roleService;

    public MainPageController(TaskServiceImpl taskService, WorkshopServiceImpl workshopService,
                              VisitDateServiceImpl visitDateService, OrderServiceImpl orderService,
                              UserServiceImpl userService, CarServiceImpl carService, RoleServiceImpl roleService){
        this.taskService = taskService;
        this.workshopService = workshopService;
        this.visitDateService = visitDateService;
        this.orderService = orderService;
        this.userService = userService;
        this. carService = carService;
        this.roleService = roleService;
    }

    @GetMapping("/")
    public String home(Model model){

        return "mainPages/index";
    }

    @GetMapping("/appointmentDate")
    public String appointmentDate(Model model){

        List<Workshop> workshopList = workshopService.findAllWorkshops();
        model.addAttribute("workshopList", workshopList);

        return "mainPages/appointmentDate";
    }

    @PostMapping("/appointmentDate")
    public String inputedAppointmentDate (@ModelAttribute("selectedWorkshop") Integer workshopId,
                                          @ModelAttribute("selectedDate") String selectedDate,
                                          RedirectAttributes redirectAttributes){

            LocalDate date = LocalDate.parse(selectedDate);
      List<VisitDate> visitDatesSelectedWorkshop = visitDateService.findVisitDateByDateAndWorkshopId(date, workshopId);

      List<String> availableVisitTime = Arrays.asList("7:00", "7:30", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30",
                                             "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30");

        List<String> availableVisitTimeList = new ArrayList<>(availableVisitTime);

        int currentIndex = 0;
        for (String visitTime: availableVisitTime) {
            for (VisitDate visitDate:visitDatesSelectedWorkshop) {
               if (visitDate.getTime().equals(visitTime)){
                   availableVisitTimeList.remove(currentIndex);
               }
               currentIndex ++;
            }

        }

        redirectAttributes.addAttribute("availableVisitTimeList", availableVisitTimeList);
        redirectAttributes.addAttribute("selectedWorkshopId", workshopId);
        redirectAttributes.addAttribute("selectedDate", selectedDate);

        return "redirect:/appointmentDetails";
    }

    @GetMapping("/appointmentDetails")
    public String appointmentDetails(Model model, @RequestParam("availableVisitTimeList") List<String> availableVisitTimeList,
                                     @RequestParam("selectedWorkshopId") Integer selectedWorkshopId,
                                     @RequestParam("selectedDate") String selectedDate){
        User user = new User();
        model.addAttribute("user", user);

        Order order = new Order();
        model.addAttribute("order", order);

        Car car = new Car();
        model.addAttribute("car", car);

        List<Task> taskList = taskService.findAllTasks();
        model.addAttribute("allTasks", taskList);
        System.out.println(taskList.toString());

        Workshop selectedWorkshop = workshopService.findWorkshopById(selectedWorkshopId);

        model.addAttribute("availableVisitTimeList", availableVisitTimeList);
        model.addAttribute("selectedWorkshopId", selectedWorkshopId);
        model.addAttribute("selectedDate", selectedDate);
        model.addAttribute("selectedWorkshop", selectedWorkshop);

        return "mainPages/appointmentDetails";
    }

    @PostMapping("/appointmentDetails")
    public String inputedAppointmentDetails (@ModelAttribute("user") User user, @ModelAttribute("order") Order order, @ModelAttribute("car") Car car,
                                             @ModelAttribute("selectedWorkshopId") Integer selectedWorkshopId, @ModelAttribute("selectedDate") String selectedDate,
                                             @ModelAttribute("selectedVisitTime") String selectedTime, @RequestParam(value = "selectedTasks", required = false) Integer[] selectedTasks){

        Double estimatedExecutionTime = 0.00;
        Integer estimatedCost = 0;

        List<Task> selectedTasksList = new ArrayList<>();

        if (selectedTasks != null) {



            for (Integer taskId : selectedTasks) {
                selectedTasksList.add(taskService.findTaskById(taskId));

            }

            for (Task task : selectedTasksList) {
                estimatedExecutionTime = estimatedExecutionTime + task.getEstimatedExecutionTime();
                estimatedCost = estimatedCost + task.getEstimatedCost();

            }
        }


        user.setRegistered(false);
        Role role = roleService.findRoleById(2);
        user.setRole(role);
        userService.save(user);

        car.setUser(user);
        carService.save(car);

        order.setTasks(selectedTasksList);
        order.setUser(user);
        order.setStatus("Pending approval");
        order.setEstimatedCost(estimatedCost);
        order.setEstimatedExecutionTime(estimatedExecutionTime);
        orderService.save(order);

        Workshop selectedWorkshop = workshopService.findWorkshopById(selectedWorkshopId);
        VisitDate selectedVisitDate = new VisitDate();
        selectedVisitDate.setDate(LocalDate.parse(selectedDate));
        selectedVisitDate.setTime(selectedTime);
        selectedVisitDate.setWorkshop(selectedWorkshop);
        selectedVisitDate.setOrder(order);
        visitDateService.save(selectedVisitDate);

        return "redirect:/";
    }
}
