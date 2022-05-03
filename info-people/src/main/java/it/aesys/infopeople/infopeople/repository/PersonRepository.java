package it.aesys.infopeople.infopeople.repository;

import it.aesys.infopeople.infopeople.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "SELECT * FROM `info-people`.person where tax_code = :tax_code", nativeQuery = true)
    List<Person> getPersonFromTaxCode(@Param("tax_code") String taxCode);

}
