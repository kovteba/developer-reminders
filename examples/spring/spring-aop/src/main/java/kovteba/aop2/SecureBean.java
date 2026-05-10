package kovteba.aop2;

public class SecureBean implements ISecureBean {

    @Override
    public void writeSecureMessage() {
        System.out.println("Every time I learn something new, it pushes some old stuff out of my brain");
    }
}
