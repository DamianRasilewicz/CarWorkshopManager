package pl.rasilewicz.car_workshop_manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rasilewicz.car_workshop_manager.entities.Task;
import pl.rasilewicz.car_workshop_manager.entities.Workshop;
import pl.rasilewicz.car_workshop_manager.repositories.TaskRepository;
import pl.rasilewicz.car_workshop_manager.repositories.WorkshopRepository;

import java.util.List;

@Service
public class WorkshopServiceImpl implements WorkshopService {

    private final WorkshopRepository workshopRepository;

    @Autowired
    public WorkshopServiceImpl(WorkshopRepository workshopRepository){
        this.workshopRepository = workshopRepository;
    }

    @Override
    public List<Workshop> findAllWorkshops() {
        return workshopRepository.findAllWorkshops();
    }
}
