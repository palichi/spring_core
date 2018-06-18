```
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
}

```

id가 user1(메소드 이름) 으로 Bean을 등록한다. 이때 user1메소드의 파라미터로 name이 있는데, 해당 값은 위의 name()메소드가 반환한 값이 자동으로 들어간다.
즉 id가 name인 값을 자동으로 받는다는 것을 의미한다. 해당 빈의 값은 리턴하는 User객체를 의미한다.

id가 user2(메소드 이름) 으로 Bean을 등록한다. 해당 빈의 값은 리턴하는 User객체를 의미한다.


```
package carami.spring.core.examples;

import carami.spring.core.config.ApplicationContextConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    private static final String CONTEXT_PATH = "applicationContext.xml";

    public static void main(String args[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        User user1 = (User)context.getBean("user1");
        System.out.println(user1.getName());

        User user2 = (User)context.getBean("user2");
        System.out.println(user2.getName());
        context.close();
    }
}

```

id가 user1과 user2인 객체를 요청한다. 모두 User객체이며 해당 객체의 getName()값을 호출하여 값을 출력하면 아래와 같이 출력되는 것을 확인할 수 있다.

carami
홍길동

