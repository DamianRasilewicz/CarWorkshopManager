package pl.rasilewicz.car_workshop_manager.services;

import pl.rasilewicz.car_workshop_manager.entities.VisitDate;

import java.util.Date;
import java.util.List;

public interface VisitDateService {

    List<VisitDate> findVisitDateByDateAndWorkshopId(Date date, Integer workshopId);
}
