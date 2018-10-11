package uti.ro.java.tutorials.listeners;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class CStartEventHandler
        implements ApplicationListener<ContextStartedEvent>{

    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println("[EVENT EXAMPLE]: ContextStartedEvent Received");
    }
}
