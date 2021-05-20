package pl.rasilewicz.car_workshop_manager.services;

import pl.rasilewicz.car_workshop_manager.entities.Workshop;

import java.util.List;

public interface WorkshopService {

    List<Workshop> findAllWorkshops();

    Workshop findWorkshopById(Integer id);
}
