package softuni.project.onlinestore.dto;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperProvider {

    @Bean
    public static ModelMapper provideModelMapper() {
        return new ModelMapper();
    }
}
