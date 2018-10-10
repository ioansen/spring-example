package uti.ro.java.tutorials;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uti.ro.java.tutorials.hello.Hello;
import uti.ro.java.tutorials.texteditor.TextEditor;

public class App {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppSpringConfig.class);

        context.start();
        Hello halo = context.getBean(Hello.class);
        halo.getMessage();
        halo.setMessage("raza");
        halo.getMessage();

        Hello helloToo = context.getBean(Hello.class);
        helloToo.getMessage(); //still raza cuz of scope singleton default
        helloToo.setMessage("back to happy");
        halo.getMessage();

        TextEditor te = context.getBean(TextEditor.class);
        te.spellCheck();

        CustomEventPublisher cvp = context.getBean(CustomEventPublisher.class);
        cvp.publish();
        cvp.publish();

        context.registerShutdownHook(); //shutdown so we can see destroy methods
        context.stop();
    }
}
