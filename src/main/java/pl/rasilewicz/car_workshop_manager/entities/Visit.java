package pl.rasilewicz.car_workshop_manager.entities;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate visitDate;
    private LocalTime visitTime;
    private String status;


    @ManyToOne
    private User user;

    @ManyToMany()
    @JoinTable(name = "visits_orders", joinColumns = @JoinColumn(name = "visit_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;
}
