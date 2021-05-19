package pl.rasilewicz.car_workshop_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan("pl.rasilewicz.car_workshop_manager.entities")
@SpringBootApplication
public class CarWorkshopManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarWorkshopManagerApplication.class, args);
    }

}
