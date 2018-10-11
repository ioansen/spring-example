package uti.ro.java.tutorials;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Hello implements InitializingBean, DisposableBean {

    private String message;

    public String getMessage() {
        return "Hello " + message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void afterPropertiesSet() {
        message = "happy";
        System.out.println("[INIT METHOD EXAMPLE]: Bean " + this.getClass().getSimpleName() + " is going through init.");
    }

    @PostConstruct
    public void init(){
        message = "happy";
        System.out.println("[INIT METHOD EXAMPLE]: Bean " + this.getClass().getSimpleName() + " is going through init.");
    }

    @Override
    public void destroy() {
        System.out.println("[DESTROY METHOD EXAMPLE]: Bean " + this.getClass().getSimpleName() + " will destroy now thank you");
    }
}
