package pl.rasilewicz.car_workshop_manager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rasilewicz.car_workshop_manager.entities.Order;
import pl.rasilewicz.car_workshop_manager.repositories.OrderRepository;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findLastOrdersByUserId(Integer userId) {
        return orderRepository.findLastOrdersByUserId(userId);
    }

    @Override
    public List<Order> findOrdersByUserId(Integer userId) {
        return orderRepository.findOrdersByUserId(userId);
    }

    @Override
    public Order findOrderById(Integer orderId) {
        return orderRepository.findOrderById(orderId);
    }

    @Override
    public void deleteById(Integer id) {
        orderRepository.deleteById(id);
    }

    @Override
    public List<Order> findLastUsersOrders() {
        return orderRepository.findLastUsersOrders();
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    @Override
    public List<Order> findThreeUndoneOrders() {
        return orderRepository.findThreeUndoneOrders();
    }

    @Override
    public List<Order> findAllUndoneOrders() {
        return orderRepository.findAllUndoneOrders();
    }

    @Override
    public Integer findNumberOfAllOrders() {
        return orderRepository.findNumberOfAllOrders();
    }
}
