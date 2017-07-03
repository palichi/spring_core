package carami.spring.core.examples;

import carami.spring.core.config.ApplicationContextConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {

    private static final String CONTEXT_PATH = "applicationContext.xml";

    public static void main(String args[]) {
        AnnotationConfigApplicationContext context1 = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        User user1 = (User)context1.getBean("user1");
        System.out.println(user1.getName());

        User user2 = (User)context1.getBean("user2");
        System.out.println(user2.getName());
        context1.close();

        System.out.println("---------------------------------------------------");

        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext(CONTEXT_PATH);
        User user3 = (User)context2.getBean("user1");
        System.out.println(user3.getName());


        User user4 = (User)context2.getBean("user2");
        System.out.println(user4.getName());
        context2.close();
    }
}
