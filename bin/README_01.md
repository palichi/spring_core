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

/src/main/resources/applicationContext.xml 

```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="name" class="java.lang.String">
        <constructor-arg value="carami"/>
    </bean>
</beans>
```

/src/main/java
에 carami.spring.core.examples 패키지 아래의 SpringApplication.java 

```
package carami.spring.core.examples;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {

    private static final String CONTEXT_PATH = "applicationContext.xml";

    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_PATH);
        String name = (String)context.getBean("name");

        System.out.println("name : " + name);

        context.close();
    }
}

```


```
ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_PATH);
```
  
ClassPath에서 XML설정파일을 읽어들여 객체를 생성하고 관리하는  ApplicationContext이다.


```
String name = (String)context.getBean("name");

```

bean id 가 name으로 설정된 객체를 요청한다. applicationContext즉 스프링 컨테이너는 name 에 해당하는 id 를 가진 빈 설정으로 생성된 객체르 반환한다.
getBean() 메소드는 어떤 값이라도 반환할 수 있기 때문에 (String)으로 형변환 한 것을 알 수 있다.

```
    <bean id="name" class="java.lang.String">
        <constructor-arg value="carami"/>
    </bean>
```
ApplicationContenxt는 필요한 모든 객체를 미리 생성해 놓는다. 위의 코드는 name으로 설정된 String객체를 반환한다. String객체를 생성할 때 생성자에 "carami"라는 문자열을 지정한 것을 알 수 있다

 
 