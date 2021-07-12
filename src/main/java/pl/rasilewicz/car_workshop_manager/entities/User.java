package pl.rasilewicz.car_workshop_manager.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 30, message = "Please input correct first name")
    private String firstName;

    @Size(min = 3, max = 30, message = "Please input correct last name")
    private String lastName;

    @Pattern(regexp = "\\d{9}", message = "Please input correct phone number")
    private String phoneNumber;

    @NotBlank(message = "Please input correct email")
    @Email(message = "Please input correct email")
    private String email;

    private Boolean registered;
    private Boolean enabled;
    private LocalDate registeredDate;
    private Integer registeredDay;
    private Integer registeredMonth;
    private Integer registeredYear;

    @Size(min = 3, max = 30, message = "Please input correct user name")
    private String userName;

    private String password;

    @OneToMany(mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Car> cars = new ArrayList<>();

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "role_id")
    private Role role ;

}
