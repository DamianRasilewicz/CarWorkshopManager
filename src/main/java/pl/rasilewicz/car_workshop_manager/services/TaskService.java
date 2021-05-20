package pl.rasilewicz.car_workshop_manager.services;

import pl.rasilewicz.car_workshop_manager.entities.Task;

import java.util.List;

public interface TaskService {

    List<Task> findAllTasks();

    Task findTaskById(Integer id);
}
