package uz.spiders.propertymanagement.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@Configuration
public class MainConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
