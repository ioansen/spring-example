package uti.ro.java.tutorials;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import uti.ro.java.tutorials.hello.Hello;
import uti.ro.java.tutorials.hello.InitHello;
import uti.ro.java.tutorials.texteditor.SpellChecker;
import uti.ro.java.tutorials.texteditor.TextEditor;

@Configuration
public class AppSpringConfig {

    @Bean(destroyMethod = "destroy")
    public Hello hello(){
        Hello hello = new Hello();
        hello.init();
        hello.setMessage("happy");
        return hello;
    }

    @Bean
    public SpellChecker spellChecker(){
        return new SpellChecker();
    }

    @Bean
    public TextEditor textEditor(){
        return new TextEditor();
    }

    @Bean
    public InitHello initHello(){
        return new InitHello();
    }
}
