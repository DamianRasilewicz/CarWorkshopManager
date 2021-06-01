package pl.rasilewicz.car_workshop_manager.repositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.rasilewicz.car_workshop_manager.entities.Order;
import java.util.List;

@Repository
@EntityScan(basePackages = "pl.rasilewicz.car_workshop_manager.entities")
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM car_workshop_manager.orders WHERE user_id = ? LIMIT 3", nativeQuery = true)
    List<Order> findLastOrdersByUserId (Integer userId);

    @Query(value = "SELECT * FROM car_workshop_manager.orders WHERE user_id = ?", nativeQuery = true)
    List<Order> findOrdersByUserId(Integer userId);
}
