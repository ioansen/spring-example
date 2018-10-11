package uti.ro.java.tutorials;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Hello hello = context.getBean(Hello.class);

        System.out.println(hello.getMessage());
        context.close();
    }
}
