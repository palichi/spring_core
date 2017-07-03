```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="name" class="java.lang.String">
        <constructor-arg value="carami"/>
    </bean>

    <bean id="user1" class="carami.spring.core.examples.User">
        <property name="name" ref="name"/>
    </bean>

    <bean id="user2" class="carami.spring.core.examples.User">
        <property name="name" value="홍길동"/>
    </bean>
</beans>
```


user1의 경우 id="name"으로 설정된 정보의 레퍼런스로 값을 주입받고
user2의 경우 "홍길동" 값(value)을 직접 주입받았다.


```
package carami.spring.core.examples;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {

    private static final String CONTEXT_PATH = "applicationContext.xml";

    public static void main(String args[]) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_PATH);
        User user1 = (User)context.getBean("user1");
        System.out.println(user1.getName());

        User user2 = (User)context.getBean("user2");
        System.out.println(user2.getName());

        context.close();
    }
}

```


ApplicationContext로부터 user1과 user2를 요청한 후 각각의 이름을 출력하고 있다.

결과 값은 

carami
홍길동

