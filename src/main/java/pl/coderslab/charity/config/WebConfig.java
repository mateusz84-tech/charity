package pl.coderslab.charity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.coderslab.charity.converters.CategoryConverters;
import pl.coderslab.charity.converters.InstitutionConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public CategoryConverters categoryConverters(){
        return new CategoryConverters();
    }

    @Bean
    public InstitutionConverter institutionConverter(){
        return new InstitutionConverter();
    }

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addConverter(categoryConverters());
        registry.addConverter(institutionConverter());
    }


}
