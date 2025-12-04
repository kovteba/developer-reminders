package kovteba.example1;

// tag::ChainDemo[]
public class ChainDemo {
    public static void main(String[] args) {

        Handler auth = new AuthHandler();
        Handler permission = new PermissionHandler();
        Handler validation = new DataValidationHandler();

        auth.setNext(permission).setNext(validation);

        System.out.println("=== Request 1 ===");
        Request req1 = new Request(true, true, true);
        auth.handle(req1);

        System.out.println("\n=== Request 2 ===");
        Request req2 = new Request(true, false, true);
        auth.handle(req2);
    }
}
// end::ChainDemo[]
