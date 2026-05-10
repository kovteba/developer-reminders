package kovteba.aop1;

import org.springframework.aop.framework.ProxyFactory;

public class AOP1Demo {
    public static void main(String[] args) {
        IMessageWriter target = new MessageWriter();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(target);

        pf.setInterfaces(IMessageWriter.class);

        IMessageWriter proxy = (IMessageWriter) pf.getProxy();
        proxy.writeMessage();
    }
}
