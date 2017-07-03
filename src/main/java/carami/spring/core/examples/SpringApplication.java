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
