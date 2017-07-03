package carami.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "carami.spring.core")
public class ApplicationContextConfig {
    @Bean
    public String name() {
        return "carami";
    }

}
