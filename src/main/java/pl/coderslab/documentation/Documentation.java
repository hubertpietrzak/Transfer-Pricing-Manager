package pl.coderslab.documentation;

import lombok.Data;
import lombok.ToString;
import pl.coderslab.company.Company;

import javax.persistence.*;

@Entity
@Data
@Table(name = "documentations")
@ToString
public class Documentation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

