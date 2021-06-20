package pl.rasilewicz.car_workshop_manager.services;

import pl.rasilewicz.car_workshop_manager.entities.VisitDate;

import java.time.LocalDate;
import java.util.List;

public interface VisitDateService {

    List<VisitDate> findVisitDateByDateAndWorkshopId(LocalDate date, Integer workshopId);

    void save (VisitDate visitDate);

    VisitDate findVisitDateById(Integer id);

}
