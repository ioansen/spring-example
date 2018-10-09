package uti.ro.java.tutorials.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello halo = (Hello) context.getBean("hello");
        halo.setMessage("raza");
        halo.getMessage();

        Hello helloToo = (Hello) context.getBean("hello");
        helloToo.getMessage(); //still raza cuz of scope singleton default
    }
}
