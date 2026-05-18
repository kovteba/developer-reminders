package kovteba.aop3;

import kovteba.aop1.SimpleBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class AOP3Demo {
    public static void main(String[] args) {
        IMessageWriter target = new MessageWriter();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(target);
        pf.setInterfaces(IMessageWriter.class);

        IMessageWriter proxy = (IMessageWriter) pf.getProxy();
        proxy.writeMessage();
    }
}
