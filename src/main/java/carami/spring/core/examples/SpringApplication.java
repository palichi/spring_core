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
