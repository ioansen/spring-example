package uti.ro.java.tutorials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import uti.ro.java.tutorials.events.CustomEvent;

@Component
public class CustomEventPublisher {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void publish(){
        CustomEvent ce = new CustomEvent(this);
        applicationEventPublisher.publishEvent(ce);
    }
}
