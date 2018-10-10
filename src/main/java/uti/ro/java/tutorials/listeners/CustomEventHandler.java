package uti.ro.java.tutorials.listeners;

import org.springframework.context.ApplicationListener;
import uti.ro.java.tutorials.events.CustomEvent;

public class CustomEventHandler implements ApplicationListener<CustomEvent> {

    @Override
    public void onApplicationEvent(CustomEvent ce){
        System.out.println(ce.toString());
    }
}
