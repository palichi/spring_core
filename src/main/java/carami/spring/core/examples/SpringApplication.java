package carami.spring.core.examples;

import carami.spring.core.config.ApplicationContextConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {

    private static final String CONTEXT_PATH = "applicationContext.xml";

    public static void main(String args[]) {

        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        String name = (String)context1.getBean("name");
        System.out.println(name);
        context1.close();

        System.out.println("---------------------------------------------------");

        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext(CONTEXT_PATH);
        User user1 = (User)context2.getBean("user1");
        System.out.println(user1.getName());


        User user2 = (User)context2.getBean("user2");
        System.out.println(user2.getName());
        context2.close();
    }
}
