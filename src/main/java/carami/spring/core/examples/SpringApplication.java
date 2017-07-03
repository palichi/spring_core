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

        User user3 = (User)context1.getBean("user3");
        System.out.println(user3.getName());

        User user4 = (User)context1.getBean("user4");
        System.out.println(user4.getName());
        context1.close();

        System.out.println("---------------------------------------------------");

        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext(CONTEXT_PATH);
        User user5 = (User)context2.getBean("user1");
        System.out.println(user5.getName());


        User user6 = (User)context2.getBean("user2");
        System.out.println(user6.getName());

        User user7 = (User)context2.getBean("user3");
        System.out.println(user7.getName());


        User user8 = (User)context2.getBean("user4");
        System.out.println(user8.getName());
        context2.close();
    }
}
