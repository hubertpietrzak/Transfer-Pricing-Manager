package pl.coderslab.transaction;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.coderslab.company.Company;

import javax.persistence.*;


@Entity
@Data
@Table(name="transactions")
@Getter
@Setter
@ToString
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Company company;

    @ManyToOne
    private Company contractors;


    private String typeOfTransaction;


    private String description;


    private int netValue;


    private int paidValue;


    private String year;


    private String statusOfDocumentation;



}
