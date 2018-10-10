package uti.ro.java.tutorials.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TimeMethodAspect {

    @Around("@annotation(uti.ro.java.tutorials.annotations.Timed)")
    public Object aroundAdvice(ProceedingJoinPoint pjp)
        throws Throwable{
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed(pjp.getArgs());
        /*try {
            result = pjp.proceed(pjp.getArgs());
        }catch (Throwable t){
            t.getMessage();
            t.printStackTrace();
        }*/
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("[TIMED METHOD]: " + pjp.getSignature().toShortString()+ ": " +  elapsedTime + "ms");
        return result;
    }
}
