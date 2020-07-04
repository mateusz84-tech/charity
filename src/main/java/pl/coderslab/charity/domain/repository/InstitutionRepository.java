package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.domain.model.Institution;

import java.util.List;


public interface InstitutionRepository extends JpaRepository<Institution, Long> {

     <S extends Institution> S save(S entity);
     Institution getById(Long id);
     void deleteById(Long id);
     List<Institution> findAllByNameAndDescription(String name, String description);

     Institution getInstitutionByName(String name);

}
