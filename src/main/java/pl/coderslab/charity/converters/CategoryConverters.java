package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.domain.model.Category;
import pl.coderslab.charity.domain.repository.CategoryRepository;

import java.util.Optional;

public class CategoryConverters implements Converter<String, Optional<Category>> {

    private CategoryRepository categoryRepository;

    @Override
    public Optional<Category> convert(String source) {

        return Optional.of(source)
                .map(Long::parseLong)
                .map(categoryRepository::findById)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
}
