package pl.rasilewicz.car_workshop_manager.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "workshops")
public class Workshop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String city;
    private String street;
    private String number;

    @OneToOne(mappedBy = "workshop")
    private Mechanic mechanic;

    @OneToMany(mappedBy = "workshop")
    private List<VisitDate> visitDates = new ArrayList<>();
}
