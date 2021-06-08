package pl.rasilewicz.car_workshop_manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rasilewicz.car_workshop_manager.entities.Car;
import pl.rasilewicz.car_workshop_manager.repositories.CarRepository;

import java.util.List;


@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository){
        this.carRepository = carRepository;
    }

    @Override
    public void save(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car findCarById(Integer id) {
       return carRepository.findCarById(id);
    }

    @Override
    public List<Car> findCarsByUserId(Integer userId) {
        return carRepository.findCarsByUserId(userId);
    }
}
