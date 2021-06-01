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

    @Column(columnDefinition = "Integer default 0")
    private Integer workingHours;

    @Column(columnDefinition = "double default 0.00")
    private Double partsCost;

    @Column(columnDefinition = "double default 0.00")
    private Double workCost;

    @Column(columnDefinition = "varchar(255) default '' ")
    private String comment;

    @Column(columnDefinition = "varchar(255) default '' ")
    private String moreInformation;

    @Column(columnDefinition = "double default 0.00")
    private Double estimatedExecutionTime;

    @Column(columnDefinition = "integer default 0")
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
