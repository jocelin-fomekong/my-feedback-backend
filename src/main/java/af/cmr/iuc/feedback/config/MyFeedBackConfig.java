package af.cmr.iuc.feedback.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class MyFeedBackConfig {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
