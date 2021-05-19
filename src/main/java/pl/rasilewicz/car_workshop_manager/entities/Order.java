package pl.rasilewicz.car_workshop_manager.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String status;
    private Double cost;
    private Integer workingHours;
    private Double partsCost;
    private Double workCost;

    @ManyToMany(mappedBy = "orders")
    private List<Visit> visits;

    @ManyToMany()
    @JoinTable(name = "orders_mechanics", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "mechanic_id"))
    private List<Mechanic> mechanics;
}
