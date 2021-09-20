package pl.rasilewicz.car_workshop_manager.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Order order;

    @ManyToOne()
    @JoinColumn(name = "workshop_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Workshop workshop;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
}
