package uti.ro.java.tutorials.events;

import org.springframework.context.ApplicationEvent;

public class CustomEvent extends ApplicationEvent {

    public CustomEvent(Object source){
        super(source);
    }

    @Override
    public String toString(){
        return "[CUSTOM EVENT EXAMPLE]: Custom EVent";
    }
}
