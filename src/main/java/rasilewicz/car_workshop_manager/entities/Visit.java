package rasilewicz.car_workshop_manager.entities;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Table(name = "visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate visitDate;
    private LocalTime visitTime;

    @ManyToOne
    private User user;
}
