package uti.ro.java.tutorials.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import uti.ro.java.tutorials.events.CustomEvent;

@Component
public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent ce){
        System.out.println(ce.toString());
    }
}
