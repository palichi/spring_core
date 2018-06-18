# IoC

## Bean factory & ApplicationContext

### Bean Factory

- 단순 컨테이너, 객체 생성 및 DI 처리


### ApplicationContext

- Bean Factory 기능 + α
- Annotation
- 스프링 설정
- 트렌젝션 관리
- 메시지 처리등등의 다양한 부가 가능


### ApplicationContext를 이용하여 String문자열 값 읽어오기

carami.spring.core.config 패키지 아래의 ApplicationContextConfig 

java config를 이용하여 설정.

@Configuration 어노테이션이 붙어있으면 java config로 인식한다.
@ComponentScan 어노테이션을 이용하여 탐색할 package를 찾는다.

```
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

```

/src/main/java
에 carami.spring.core.examples 패키지 아래의 SpringApplication.java 

```
package carami.spring.core.examples;

import carami.spring.core.config.ApplicationContextConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApplication {

    private static final String CONTEXT_PATH = "applicationContext.xml";

    public static void main(String args[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        String name = (String)context.getBean("name");

        System.out.println("name : " + name);

        context.close();
    }
}

```


```
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        
```
  
ApplicationContextConfig.class 를 읽어들이는 ApplicationContext객체를 생성한다.


```
String name = (String)context.getBean("name");

```

bean id 가 name으로 설정된 객체를 요청한다. applicationContext즉 스프링 컨테이너는 name 에 해당하는 id 를 가진 빈 설정으로 생성된 객체를 반환한다.
getBean() 메소드는 어떤 값이라도 반환할 수 있기 때문에 (String)으로 형변환 한 것을 알 수 있다.

```
    @Bean
    public String name() {
        return "carami";
    }
```
ApplicationContenxt는 필요한 모든 객체를 미리 생성해 놓는다. 
@Bean이 붙어있는 메소드 이름이 name()이면 id값이 name으로 객체를 생성한다는 것을 의미한다. 해당 객체는 리턴하는 String객체이다.


 
 