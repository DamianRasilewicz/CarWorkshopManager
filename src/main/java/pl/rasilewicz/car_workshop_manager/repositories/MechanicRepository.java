package pl.rasilewicz.car_workshop_manager.repositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rasilewicz.car_workshop_manager.entities.Mechanic;

@Repository
@EntityScan(basePackages = "pl.rasilewicz.car_workshop_manager.entities")
public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {

    @Query(value = "SELECT  COUNT(id) FROM car_workshop_manager.mechanics",nativeQuery = true)
    Integer findNumberOfMechanics();
}
