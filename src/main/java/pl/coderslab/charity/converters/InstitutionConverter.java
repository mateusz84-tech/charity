package pl.coderslab.charity.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.charity.domain.model.Institution;
import pl.coderslab.charity.domain.repository.InstitutionRepository;

import java.util.Optional;

public class InstitutionConverter implements Converter<String, Optional<Institution>> {

    private InstitutionRepository institutionRepository;

    @Override
    public Optional<Institution> convert(String source){

        return Optional.of(source)
                .map(Long::parseLong)
                .map(institutionRepository::findById)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Autowired
    public void setInstitutionRepository(InstitutionRepository institutionRepository){
        this.institutionRepository = institutionRepository;
    }
}
