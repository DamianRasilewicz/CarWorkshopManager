package pl.rasilewicz.car_workshop_manager.services;


import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.rasilewicz.car_workshop_manager.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    void save (User user);

    User findByUserName(String userName);

    User findUserById(Integer id);

    List<User> findAllUsers(String userName);

    void deleteById(Integer id);

    Integer findNumberOfAllUsers();

    Integer findNumberOfMonthlyRegisteredUsers(Integer month, Integer year);

}
