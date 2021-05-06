package rasilewicz.entities;


import javax.persistence.*;

@Entity
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
}
