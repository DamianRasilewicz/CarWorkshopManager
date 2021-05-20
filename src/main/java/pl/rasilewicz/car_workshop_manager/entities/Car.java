package pl.rasilewicz.car_workshop_manager.entities;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String brand;
    private String model;
    private String productionYear;
    private String engineType;
    private String engineCapacity;
    private String enginePower;

    @ManyToOne
    private User user;
}
