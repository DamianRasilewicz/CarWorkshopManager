package pl.rasilewicz.car_workshop_manager.repositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.rasilewicz.car_workshop_manager.entities.Car;


@Repository
@EntityScan(basePackages = "pl.rasilewicz.car_workshop_manager.entities")
public interface CarRepository extends JpaRepository<Car, Integer> {

}
