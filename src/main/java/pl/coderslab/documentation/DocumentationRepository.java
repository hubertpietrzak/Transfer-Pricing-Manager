package pl.coderslab.documentation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.company.Company;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface DocumentationRepository extends JpaRepository<Documentation, Long> {

    List<Documentation> findByYearAndCompany_IdAndTypeOfTransaction(String year, long companyId,String typeOfTransaction);

    List<Documentation> findAllByStatusOfDocumentation(String statusOfDocumentation);

    Integer countAllByStatusOfDocumentation(String statusOfDocumentation);
    Integer countByStatusOfDocumentation(String statusOfDocumentation);




}
