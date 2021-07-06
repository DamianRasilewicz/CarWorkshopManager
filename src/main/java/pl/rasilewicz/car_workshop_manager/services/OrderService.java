package pl.rasilewicz.car_workshop_manager.services;


import pl.rasilewicz.car_workshop_manager.entities.Order;

import java.util.List;

public interface OrderService {

    void save (Order order);

    List<Order> findLastOrdersByUserId (Integer userId);

    List<Order> findOrdersByUserId(Integer userId);

    Order findOrderById(Integer orderId);

    void deleteById (Integer id);

    List<Order> findLastUsersOrders();

    List<Order> findAllOrders();

    List<Order> findThreeUndoneOrders();

    List<Order> findAllUndoneOrders();

    Integer findNumberOfAllOrders();

}
