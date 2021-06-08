package pl.rasilewicz.car_workshop_manager.repositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rasilewicz.car_workshop_manager.entities.Car;
import java.util.List;


@Repository
@EntityScan(basePackages = "pl.rasilewicz.car_workshop_manager.entities")
public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findCarById(Integer id);

    @Query(value = "SELECT * FROM car_workshop_manager.cars WHERE user_id = ?", nativeQuery = true)
    List<Car> findCarsByUserId(Integer userId);

}
