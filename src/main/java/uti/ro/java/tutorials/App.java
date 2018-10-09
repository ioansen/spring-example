package uti.ro.java.tutorials;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import uti.ro.java.tutorials.hello.Hello;
import uti.ro.java.tutorials.texteditor.TextEditor;

public class App {

    public static void main(String[] args){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello halo = (Hello) context.getBean("hello");
        halo.getMessage();
        halo.setMessage("raza");
        halo.getMessage();

        Hello helloToo = (Hello) context.getBean("hello");
        helloToo.getMessage(); //still raza cuz of scope singleton default
        helloToo.setMessage("back to happy");
        halo.getMessage();

        TextEditor te = (TextEditor) context.getBean("textEditor");
        te.spellCheck();

        context.registerShutdownHook(); //shutdown so we can see destroy methods
    }
}
