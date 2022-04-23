package pl.coderslab.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
