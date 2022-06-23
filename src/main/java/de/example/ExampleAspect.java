package de.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExampleAspect {

    @Around("execution(String de.example.Example.sayHello(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Example");
        return joinPoint.proceed();
    }


    @Around("(execution(void de.example.CharArrayContainer.setCharArray(char[]))) && args(s)")
    public void aroundField(ProceedingJoinPoint joinPoint, char[] s) throws Throwable {
        System.out.println("Around Field");
        joinPoint.proceed();
    }

}
