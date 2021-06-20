package pl.rasilewicz.car_workshop_manager.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "visitDates")
public class VisitDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer day;
    private Integer month;
    private Integer year;
    private LocalDate date;
    private String time;

    @OneToOne()
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    private Workshop workshop;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
