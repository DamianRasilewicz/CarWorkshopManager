package pl.rasilewicz.car_workshop_manager.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Table(name = "mechanics")
public class Mechanic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;
    private String lastName;
    private String speciality;
    private Integer seniority;

    @OneToOne()
    @JoinColumn(name = "workshop_id")
    private Workshop workshop;

    @ManyToMany(mappedBy = "mechanics")
    private List<Order> orders ;
}
