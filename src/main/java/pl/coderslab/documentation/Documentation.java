package pl.coderslab.documentation;

import lombok.Data;
import lombok.ToString;
import pl.coderslab.company.Company;

import javax.persistence.*;



@SqlResultSetMapping(
        name="DocumentationMapping",
        entities = @EntityResult(
                entityClass = Documentation.class,
                fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "company", column = "company_id"),
                        @FieldResult(name = "contractors", column = "contractors_id"),
                        @FieldResult(name = "typeOfTransaction", column = "type_of_transaction"),
                        @FieldResult(name = "description", column = "description"),
                        @FieldResult(name = "netValue", column = "net_value"),
                        @FieldResult(name = "paidValue", column = "paid_value"),
                }
        )
)

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

