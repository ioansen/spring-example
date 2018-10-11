package uti.ro.java.tutorials.texteditor;

import org.springframework.stereotype.Component;

@Component
public class SpellChecker {

    public SpellChecker(){
        System.out.println("[DI EXAMPLE]:Inside SpellChecker constructor." );
    }

    public void checkSpelling() {
        System.out.println("[DI EXAMPLE]: Inside checkSpelling." );
    }
}