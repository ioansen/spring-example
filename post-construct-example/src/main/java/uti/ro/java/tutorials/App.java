package uti.ro.java.tutorials;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("uti.ro.java.tutorials")
public class App 
{
    public static void main( String[] args )
    {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(App.class);

        Hello hello = context.getBean(Hello.class);

        System.out.println(hello.getMessage());
        context.close();
    }
}
