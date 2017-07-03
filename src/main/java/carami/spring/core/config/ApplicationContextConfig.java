package carami.spring.core.config;

import carami.spring.core.examples.User;
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

    @Bean
    public User user1(String name) {
        User user = new User();
        user.setName(name);
        return user;
    }

    @Bean
    public User user2() {
        User user = new User();
        user.setName("홍길동");
        return user;
    }

    @Bean
    public User user3(String name) {
        User user = new User(name);
        return user;
    }

    @Bean
    public User user4() {
        User user = new User("홍길동");
        return user;
    }
}
