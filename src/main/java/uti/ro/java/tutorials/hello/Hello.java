package uti.ro.java.tutorials.hello;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Hello {

    private String message;

    public String getMessage() {
        System.out.println("Hello " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @PostConstruct
    public void init(){
        message = "happy";
        System.out.println("[INIT METHOD EXAMPLE]: Bean " + this.getClass().getSimpleName() + " is going through init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[DESTROY METHOD EXAMPLE]: Bean " + this.getClass().getSimpleName() + " will destroy now thank you");
    }
}
