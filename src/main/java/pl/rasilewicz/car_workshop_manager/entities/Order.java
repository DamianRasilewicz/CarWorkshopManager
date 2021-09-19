package pl.rasilewicz.car_workshop_manager.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
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

    @Column(columnDefinition = "Decimal(5,2) default 0.00")
    private double finalCost;

    @Column(columnDefinition = "integer default 0")
    private Integer workingHours;

    @Column(columnDefinition = "Decimal(5,2) default 0.00")
    private double partsCost;

    @Column(columnDefinition = "Decimal(5,2) default 0.00")
    private double workCost;

    @Column(columnDefinition = "varchar(255) default '' ")
    private String comment;

    @Column(columnDefinition = "varchar(255) default '' ")
    private String moreInformation;

    @Column(columnDefinition = "Decimal(5,2) default 0.00")
    private double estimatedExecutionTime;

    @Column(columnDefinition = "integer default 0")
    private Integer estimatedWorkCost;


    @ManyToMany()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "orders_mechanics", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "mechanic_id"))
    private List<Mechanic> mechanics;

    @ManyToMany()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinTable(name = "orders_tasks", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;

    @ManyToOne
    private User user;

    @OneToOne(mappedBy = "order")
    private VisitDate visitDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Car car;

}
