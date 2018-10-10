package uti.ro.java.tutorials.aspects;

import org.aspectj.lang.annotation.*;

@Aspect
public class LoggingAspectExample {
    /** Following is the definition for a pointcut to select
     *  all the methods available. So advice will be called
     *  for all the methods.
     */
    @Pointcut("execution(* uti.ro.java.tutorials.hello.Hello.*(..))")
    private void logging(){}

    /**
     * This is the method which I would like to execute
     * before a selected method execution.
     */
    @Before("logging()")
    public void beforeAdvice(){
        System.out.println("[ASPECT EXAMPLE]: Before advice.");
    }

    /**
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    @After("logging()")
    public void afterAdvice(){
        System.out.println("[ASPECT EXAMPLE]: After advice.");
    }

    /**
     * This is the method which I would like to execute
     * when any method returns.
     */
    @AfterReturning(pointcut = "logging()", returning = "retVal")
    public void afterReturningAdvice(Object retVal){
        System.out.println("[ASPECT EXAMPLE]: After advice Returning:" + retVal );
    }

    /**
     * This is the method which I would like to execute
     * if there is an exception raised by any method.
     */
    @AfterThrowing(pointcut = "logging()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex){
        System.out.println("[ASPECT EXAMPLE]: After advice example exception: " + ex);
    }

   /* @Around("selectAll()")
    public void doAroundTask(){
        System.out.println("Around");
    }*/
}
