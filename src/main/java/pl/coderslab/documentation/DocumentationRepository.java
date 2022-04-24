package pl.coderslab.documentation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface DocumentationRepository extends JpaRepository<Documentation, Long> {


//    @Query(nativeQuery = true, value = "select sum(net_value) as net, company_id,type_of_transaction from transactions group by company_id, type_of_transaction having net > 2000000")
//    List<Documentation> findDocumentation;
//
//    @NamedNativeQuery(
//            name = "Documentation",
//            query = "select sum(net_value) as net, company_id,type_of_transaction from transactions group by company_id, type_of_transaction having net > 2000000",
//            resultSetMapping = "DocumentationMapping");


}
