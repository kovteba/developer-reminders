package kovteba.aop3;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, 
             Object[] args, Object target) throws Throwable {
        System.out.println("");
        System.out.println("After method: " + method.getName());
    }
}
