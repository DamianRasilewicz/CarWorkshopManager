package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.rasilewicz.car_workshop_manager.entities.*;
import pl.rasilewicz.car_workshop_manager.services.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.*;

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
    public String home(){

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

      List<String> availableVisitTimeList = new ArrayList<>();
      Collections.addAll(availableVisitTimeList, "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00",
              "14:00", "15:00", "16:00");

      List<String> noAvailableVisitTimeList = new ArrayList<>();

        for (VisitDate visitDate: visitDatesSelectedWorkshop ) {
            noAvailableVisitTimeList.add(visitDate.getTime());
        }

        availableVisitTimeList.removeAll(noAvailableVisitTimeList);

        redirectAttributes.addAttribute("availableVisitTimeList", availableVisitTimeList);
        redirectAttributes.addAttribute("selectedWorkshopId", workshopId);
        redirectAttributes.addAttribute("selectedDate", selectedDate);

        return "redirect:/appointmentDetails";
    }

    @GetMapping("/appointmentDetails")
    public String appointmentDetails(Model model, @RequestParam("availableVisitTimeList") List<String> availableVisitTimeList,
                                     @RequestParam("selectedWorkshopId") Integer selectedWorkshopId,
                                     @RequestParam("selectedDate") String selectedDate, HttpSession session){
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

        List<String> carBrandsList = Arrays.asList("Abarth", "Acura","Alfa Romeo", "Alpine","Aston Martin", "Audi", "Bentley", "BMW" , "Brabus" ,"Bugatti", "Buick", "Cadillac",
                                                    "Chevrolet", "Chrysler", "Citroën", "Daihatsu", "Dodge", "Ferrari", "Fiat", "Ford", "FSO", "GAZ", "GMC",  "Honda",
                                                    "Hummer", "Hyundai", "Infiniti", "Isuzu", "Iveco", "Jaguar", "Jeep", "Kia", "Lada", "Lamborghini", "Lancia",
                                                    "Land Rover", "Lexus", "Lincoln", "Lotus", "Maserati", "Maybach", "Mazda", "Mercedes-Benz", "MG", "MINI", "Mitsubishi",
                                                    "Morgan", "Moskvich", "Nissan", "Oldsmobile", "Opel", "Peugeot", "Pontiac", "Porsche", "Renault", "Rolls-Royce","Rover",
                                                    "Saab","Skoda","Subaru","Suzuki","Tata","Tesla","Toyota","UAZ","Vauxhall","Volkswagen","Volvo","Lotus");

        List<String> engineTypesList = Arrays.asList("Benzine", "Diesel", "Hybrid", "Benzine + LPG", "CNG");

        model.addAttribute("availableVisitTimeList", availableVisitTimeList);
        session.setAttribute("availableVisitTimeList", availableVisitTimeList);
        model.addAttribute("selectedWorkshopId", selectedWorkshopId);
        model.addAttribute("selectedDate", selectedDate);
        model.addAttribute("selectedWorkshop", selectedWorkshop);
        session.setAttribute("selectedWorkshop", selectedWorkshop);
        model.addAttribute("carBrandsList", carBrandsList);
        session.setAttribute("carBrandsList", carBrandsList);
        model.addAttribute("engineTypesList", engineTypesList);
        session.setAttribute("engineTypesList", engineTypesList);
        return "mainPages/appointmentDetails";
    }

    @PostMapping("/appointmentDetails")
    public String inputtedAppointmentDetails(@ModelAttribute("user") @Valid User user, BindingResult resultUser, @ModelAttribute("order") @Valid Order order,
                                             BindingResult resultOrder, @ModelAttribute("car") @Valid Car car, BindingResult resultCar, @ModelAttribute("selectedDate") String selectedDate,
                                             @ModelAttribute("selectedVisitTime") String selectedTime, @RequestParam(value = "selectedTasks", required = false) Integer[] selectedTasks, Model  model,
                                             @SessionAttribute ("availableVisitTimeList") List<String> availableVisitTimeList, @SessionAttribute ("selectedWorkshop") Workshop selectedWorkshop,
                                             SessionStatus sessionStatus, @SessionAttribute("carBrandsList") List<String> carBrandsList, @SessionAttribute("engineTypesList") List<String> engineTypesList){


        if (resultUser.hasErrors() || resultOrder.hasErrors() || resultCar.hasErrors()) {
            model.addAttribute("selectedWorkshop", selectedWorkshop);
            model.addAttribute("availableVisitTimeList", availableVisitTimeList);
            model.addAttribute("carBrandsList", carBrandsList);
            model.addAttribute("engineTypesList", engineTypesList);

            return "mainPages/appointmentDetails";
        }

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
        order.setEstimatedWorkCost(estimatedCost);
        order.setEstimatedExecutionTime(estimatedExecutionTime);
        orderService.save(order);

        LocalDate selectedDateParsed = LocalDate.parse(selectedDate);

        VisitDate selectedVisitDate = new VisitDate();
        selectedVisitDate.setDate(selectedDateParsed);
        selectedVisitDate.setTime(selectedTime);
        selectedVisitDate.setWorkshop(selectedWorkshop);
        selectedVisitDate.setOrder(order);
        selectedVisitDate.setDay(selectedDateParsed.getDayOfMonth());
        selectedVisitDate.setMonth(selectedDateParsed.getMonthValue());
        selectedVisitDate.setYear(selectedDateParsed.getYear());
        selectedVisitDate.setUser(user);

        visitDateService.save(selectedVisitDate);

        sessionStatus.setComplete();

        return "redirect:/appointmentSuccess";
    }

    @GetMapping("/appointmentSuccess")
    public String successfullyMadeAppointment(){

        return "mainPages/appointmentSuccess";
    }


}
