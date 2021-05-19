package rasilewicz.car_workshop_manager.entities;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
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
}
