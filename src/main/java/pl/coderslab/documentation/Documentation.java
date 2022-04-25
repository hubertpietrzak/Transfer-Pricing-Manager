package pl.coderslab.documentation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.coderslab.company.Company;

import javax.persistence.*;


//@NamedNativeQuery(
//        name = "Documentation",
//        query = "select sum(net_value) as net, company_id,type_of_transaction from transactions group by company_id, type_of_transaction having net > 2000000",
//        resultSetMapping = "DocumentationMapping")
//
//@SqlResultSetMapping(
//        name="DocumentationMapping",
//        entities = @EntityResult(
//                entityClass = Documentation.class,
//                fields = {
//                        @FieldResult(name = "id", column = "id"),
//                        @FieldResult(name = "company", column = "company_id"),
//                        @FieldResult(name = "contractors", column = "contractors_id"),
//                        @FieldResult(name = "typeOfTransaction", column = "type_of_transaction"),
//                        @FieldResult(name = "description", column = "description"),
//                        @FieldResult(name = "netValue", column = "net_value"),
//                        @FieldResult(name = "paidValue", column = "paid_value"),
//                }
//        )
//)

@Entity
@Data
@Table(name = "documentations")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Documentation {

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

