package pl.rasilewicz.car_workshop_manager.services;


import pl.rasilewicz.car_workshop_manager.entities.Car;
import pl.rasilewicz.car_workshop_manager.entities.Role;

public interface RoleService {

    Role findRoleById(Integer id);

    Role findRoleByName(String name);

}
