package pl.rasilewicz.car_workshop_manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rasilewicz.car_workshop_manager.entities.VisitDate;
import pl.rasilewicz.car_workshop_manager.entities.Workshop;
import pl.rasilewicz.car_workshop_manager.repositories.VisitDateRepository;
import pl.rasilewicz.car_workshop_manager.repositories.WorkshopRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class VisitDateServiceImpl implements VisitDateService {

    private final VisitDateRepository visitDateRepository;

    @Autowired
    public VisitDateServiceImpl(VisitDateRepository visitDateRepository){
        this.visitDateRepository = visitDateRepository;
    }

    @Override
    public List<VisitDate> findVisitDateByDateAndWorkshopId(LocalDate date, Integer workshopId) {
        return visitDateRepository.findVisitDateByDateAndWorkshopId(date, workshopId);
    }

    @Override
    public void save(VisitDate visitDate) {
        visitDateRepository.save(visitDate);
    }

    @Override
    public VisitDate findVisitDateById(Integer id) {
        return visitDateRepository.findVisitDateById(id);
    }

    @Override
    public Integer findNumberOfVisitDatesByMonthByUserId(Integer month, Integer userId) {
        return visitDateRepository.findNumberOfVisitDatesByMonthByUserId(month, userId);
    }

    @Override
    public Integer findNumberOfVisitDatesAllUsers(Integer month) {
        return visitDateRepository.findNumberOfVisitDatesAllUsers(month);
    }
}
