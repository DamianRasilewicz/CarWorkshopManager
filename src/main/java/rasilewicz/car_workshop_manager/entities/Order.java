package rasilewicz.car_workshop_manager.entities;

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


    @ManyToMany(mappedBy = "orders")
    private List<Visit> visits;
}
