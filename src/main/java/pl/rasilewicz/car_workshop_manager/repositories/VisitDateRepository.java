package pl.rasilewicz.car_workshop_manager.repositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rasilewicz.car_workshop_manager.entities.VisitDate;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
@EntityScan(basePackages = "pl.rasilewicz.car_workshop_manager.entities")
public interface VisitDateRepository extends JpaRepository<VisitDate, Integer> {

//    @Query(value = "SELECT * FROM car_workshop_manager.tasks", nativeQuery = true)
    List<VisitDate> findVisitDateByDateAndWorkshopId(LocalDate date, Integer workshopId);

    VisitDate findVisitDateById(Integer id);

    @Query(value = "SELECT  COUNT(id) FROM car_workshop_manager.visit_dates WHERE month = ?1 AND user_id = ?2" ,nativeQuery = true)
    Integer findNumberOfVisitDatesByMonthByUserId(Integer month, Integer userId);

    @Query(value = "SELECT  COUNT(id) FROM car_workshop_manager.visit_dates WHERE month = ?1 AND year = ?2" ,nativeQuery = true)
    Integer findNumberOfVisitDatesAllUsersOfYear(Integer month, Integer year);
}
