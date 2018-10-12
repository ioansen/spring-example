package uti.ro.java.tutorials;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import uti.ro.java.tutorials.hello.Hello;
import uti.ro.java.tutorials.jdbcex.Employee;
import uti.ro.java.tutorials.jdbcex.EmployeeDAOImpl;
import uti.ro.java.tutorials.texteditor.TextEditor;

@Configuration
@EnableAspectJAutoProxy
@EnableTransactionManagement(proxyTargetClass = true)
@ComponentScan("uti.ro.java.tutorials")
public class App {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(App.class);

        context.start();
        Hello halo = context.getBean(Hello.class);
        System.out.println(halo.getMessage());
        halo.setMessage("raza");
        System.out.println(halo.getMessage());

        Hello helloToo = context.getBean(Hello.class);
        System.out.println(helloToo.getMessage()); //still raza cuz of scope singleton default
        helloToo.setMessage("back to happy");
        System.out.println(halo.getMessage());

        TextEditor te = context.getBean(TextEditor.class);
        te.spellCheck();

        CustomEventPublisher cvp = context.getBean(CustomEventPublisher.class);
        cvp.publish();
        cvp.publish();

        EmployeeDAOImpl ejdbct = context.getBean(EmployeeDAOImpl.class); //i cannot understand the error
        long id = ejdbct.insert(new Employee("Liviu", "Larnaca", 2500, "dr", "nada"));
        for(Employee e: ejdbct.listEmployees()){
            System.out.println(e);
        }

        ejdbct.update(15, new Employee("Grija", "Larnaca", 2500, "dr", "nada"));

        ejdbct.delete(id);
        context.registerShutdownHook(); //shutdown so we can see destroy methods
        context.stop();
    }
}
