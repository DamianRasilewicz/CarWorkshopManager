package pl.rasilewicz.car_workshop_manager.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String status;

    @Column(columnDefinition = "double default 0.00")
    private Double cost;

    private Integer workingHours;
    private Double partsCost;
    private Double workCost;
    private String comment;
    private String moreInformation;
    private Double estimatedExecutionTime;
    private Integer estimatedCost;


    @ManyToMany()
    @JoinTable(name = "orders_mechanics", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "mechanic_id"))
    private List<Mechanic> mechanics;

    @ManyToMany()
    @JoinTable(name = "orders_tasks", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "order")
    private VisitDate visitDate;

}
