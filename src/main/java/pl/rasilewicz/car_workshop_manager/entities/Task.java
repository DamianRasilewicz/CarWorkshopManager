package pl.rasilewicz.car_workshop_manager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String description;
    private Double estimatedExecutionTime;
    private Integer estimatedCost;

    @ManyToMany(mappedBy = "tasks")
    private List<Order> orders ;

    public Task(){};
}
