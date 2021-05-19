package pl.rasilewicz.car_workshop_manager.entities;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Boolean registered;
    private String username;
    private String password;
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Visit> visits = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Car> cars = new ArrayList<>();

}
