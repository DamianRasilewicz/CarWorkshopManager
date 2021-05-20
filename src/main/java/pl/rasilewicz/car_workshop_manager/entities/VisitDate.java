package pl.rasilewicz.car_workshop_manager.entities;


import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Table(name = "visitDates")
public class VisitDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Date date;
    private String time;

    @OneToOne()
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    private Workshop workshop;
}
