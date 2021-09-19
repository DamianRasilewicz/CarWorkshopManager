package pl.rasilewicz.car_workshop_manager.entities;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;


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

    @NotBlank(message = "Please input model")
    private String model;

//    @Range(min = 1800, max = 2022, message = "Please input correct productionYear")
    private String productionYear;

    private String engineType;

//    @Range(min = 100, max = 9999, message = "Please input correct engine capacity")
    private String engineCapacity;

//    @Range(min = 10, max = 2000, message = "Please input correct engine power")
    private String enginePower;

    @ManyToOne
    private User user;
}
