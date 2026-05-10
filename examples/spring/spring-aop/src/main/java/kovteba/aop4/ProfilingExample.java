package kovteba.aop4;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingExample {

    public static void main(String[] args) {
        Worker bean = getWorkerBean();
        bean.doSomeWork(10000000);
    }

    private static Worker getWorkerBean() {
        Worker target = new WorkerBean();
        ProxyFactory factory = new ProxyFactory();

        // Вказуємо інтерфейс явно
        factory.setInterfaces(Worker.class);
        factory.setTarget(target);
        factory.addAdvice(new ProfilingInterceptor());

        // forceProxyTargetClass(false) - це дефолт, але ми підстрахуємось
        factory.setProxyTargetClass(false);

        return (Worker) factory.getProxy();
    }
}
