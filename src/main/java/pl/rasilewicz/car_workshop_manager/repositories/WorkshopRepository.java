package pl.rasilewicz.car_workshop_manager.repositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rasilewicz.car_workshop_manager.entities.Workshop;

import java.util.List;

@Repository
@EntityScan(basePackages = "pl.rasilewicz.car_workshop_manager.entities")
public interface WorkshopRepository extends JpaRepository<Workshop, Integer> {

    @Query(value = "SELECT * FROM car_workshop_manager.workshops", nativeQuery = true)
    List<Workshop> findAllWorkshops();
}
