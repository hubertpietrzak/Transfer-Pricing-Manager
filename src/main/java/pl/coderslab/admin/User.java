package pl.coderslab.admin;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.company.Company;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 60)
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToOne
    private Company company;
    private String password;
    private int enabled;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles;

}