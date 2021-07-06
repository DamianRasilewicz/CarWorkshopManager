package pl.rasilewicz.car_workshop_manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rasilewicz.car_workshop_manager.repositories.CarRepository;
import pl.rasilewicz.car_workshop_manager.repositories.MechanicRepository;

@Service
public class MechanicServiceImpl implements MechanicService{

    private final MechanicRepository mechanicRepository;

    @Autowired
    public MechanicServiceImpl(MechanicRepository mechanicRepository){
        this.mechanicRepository = mechanicRepository;
    }

    @Override
    public Integer findNumberOfMechanics() {
        return mechanicRepository.findNumberOfMechanics();
    }
}
