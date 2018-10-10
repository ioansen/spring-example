package uti.ro.java.tutorials.hello;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class InitHello  implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[POST PROCESSOR EXAMPLE]: BeforeInitialization : " + beanName);
        return bean;  // you can return any other object as well
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("[POST PROCESSOR EXAMPLE]: AfterInitialization : " + s);
        return o;  // you can return any other object as well
    }

}
