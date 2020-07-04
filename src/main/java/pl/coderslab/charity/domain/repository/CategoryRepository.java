package pl.coderslab.charity.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.charity.domain.model.Category;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByName(String name);

    Category getCategoryById(Long id);

    Category getCategoryByName(String name);

}
