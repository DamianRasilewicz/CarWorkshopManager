package pl.rasilewicz.car_workshop_manager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.rasilewicz.car_workshop_manager.entities.*;
import pl.rasilewicz.car_workshop_manager.services.TaskServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {

    private final TaskServiceImpl taskService;

    public MainPageController(TaskServiceImpl taskService){
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String home(Model model){

        return "mainPages/index";
    }

    @GetMapping("/appointment")
    public String makeAnAppointment(Model model){
        User user = new User();
        model.addAttribute("user", user);

        Order order = new Order();
        model.addAttribute("order", order);

        Car car = new Car();
        model.addAttribute("car", car);

        List<Task> taskList = taskService.findAllTasks();
        model.addAttribute("allTasks", taskList);
        System.out.println(taskList.toString());

        return "mainPages/appointment";
    }

    @PostMapping("/appointment")
    public String madeAppointment (@ModelAttribute("user") User user, @ModelAttribute("order") Order order, @ModelAttribute("car") Car car){


        return "redirect:/appointment?success";
    }
}
