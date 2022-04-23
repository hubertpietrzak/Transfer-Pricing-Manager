package pl.coderslab.company;

import lombok.Data;
import pl.coderslab.admin.User;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name="companies")
public class Company {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String street;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String city;


   // @NIP
    private String nip;


   // @REGON
    private String regon;


    private int incomes;

    @NotBlank
    private String PKD;


    private String statusOfInventory;

    @ManyToOne
    private User user;




}
