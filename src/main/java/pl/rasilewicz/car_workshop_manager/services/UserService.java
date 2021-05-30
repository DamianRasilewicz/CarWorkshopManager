package pl.rasilewicz.car_workshop_manager.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import pl.rasilewicz.car_workshop_manager.entities.User;

public interface UserService extends UserDetailsService {

    void save (User user);

    User findByUserName(String userName);

    User findUserById(Long id);

}
