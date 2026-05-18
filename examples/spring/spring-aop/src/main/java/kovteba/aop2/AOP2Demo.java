package kovteba.aop2;

import org.springframework.aop.framework.ProxyFactory;

public class AOP2Demo {
    public static void main(String[] args) {
        SecurityManager mgr = new SecurityManager();

        ISecureBean bean = getSecureBean();

        mgr.login("chris", "pwd");
        bean.writeSecureMessage();
        mgr.logout();

        try {
            mgr.login("invaliduser", "pwd");
            bean.writeSecureMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            mgr.logout();
        }

        try {
            bean.writeSecureMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        }
    }

    private static ISecureBean getSecureBean() {
        SecureBean target = new SecureBean();

        SecurityAdviceBefore advice = new SecurityAdviceBefore();

        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);

        // важно: заставляем использовать JDK proxy
        factory.setInterfaces(ISecureBean.class);

        return (ISecureBean) factory.getProxy();
    }
}
