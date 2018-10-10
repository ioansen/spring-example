package uti.ro.java.tutorials.aspects;

import org.aspectj.lang.JoinPoint;
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
    public void beforeAdvice(JoinPoint joinPoint){
        System.out.println("[ASPECT EXAMPLE]: Before advice on " +
                joinPoint.getTarget().getClass().getSimpleName() + "'s " +
                joinPoint.getSignature().getName());
        //System.out.println("[ASPECT EXAMPLE]: JoinPoint target: " + joinPoint.getTarget().getClass().getSimpleName());
        //System.out.println("[ASPECT EXAMPLE]: JoinPoint kind: " + joinPoint.getKind());
        //System.out.println("[ASPECT EXAMPLE]: JoinPoint signature: " + joinPoint.getSignature());
        //System.out.println("[ASPECT EXAMPLE]: JoinPoint source location: " + joinPoint.getSourceLocation());
       // System.out.println("[ASPECT EXAMPLE]: JoinPoint this: " + joinPoint.getThis().getClass().getSimpleName());
       // System.out.println("[ASPECT EXAMPLE]: JoinPoint class: " + joinPoint.getClass().getSimpleName());
        //System.out.println("[ASPECT EXAMPLE]: JoinPoint: " + joinPoint);
        /*for (Object a: joinPoint.getArgs()){
            System.out.println("[ASPECT EXAMPLE]: JoinPoint args: " + a);
        }*/

    }

    /*
     * This is the method which I would like to execute
     * after a selected method execution.
     */
    /*@After("logging()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("[ASPECT EXAMPLE]: After advice " + joinPoint.getTarget().getClass().getSimpleName());
    }*/

    /*
     * This is the method which I would like to execute
     * when any method returns.
     */
    /*@AfterReturning(pointcut = "logging()", returning = "retVal")
    public void afterReturningAdvice(JoinPoint joinPoint, Object retVal){
        System.out.println("[ASPECT EXAMPLE]: After advice Returning:" + retVal );
    }*/

    /*
     * This is the method which I would like to execute
     * if there is an exception raised by any method.
     */
    /*@AfterThrowing(pointcut = "logging()", throwing = "ex")
    public void AfterThrowingAdvice(IllegalArgumentException ex){
        System.out.println("[ASPECT EXAMPLE]: After advice example exception: " + ex);
    }*/

   /* @Around("selectAll()")
    public void doAroundTask(){
        System.out.println("Around");
    }*/
}
