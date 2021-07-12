package pl.rasilewicz.car_workshop_manager.repositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rasilewicz.car_workshop_manager.entities.User;
import java.util.List;

@Repository
@EntityScan(basePackages = "pl.rasilewicz.car_workshop_manager.entities")
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByUserName(String userName);

    User findUserById(Integer id);

    @Query(value = "SELECT * FROM car_workshop_manager.users WHERE NOT user_name = ?;" ,nativeQuery = true)
    List<User> findAllUsers(String userName);

    @Query(value = "SELECT COUNT(id) FROM car_workshop_manager.users;" ,nativeQuery = true)
    Integer findNumberOfAllUsers();
//
//    @Query(value = "SELECT COUNT(id) FROM car_workshop_manager.users;" ,nativeQuery = true)
//    Integer findNumberOfAllUsers();
}
