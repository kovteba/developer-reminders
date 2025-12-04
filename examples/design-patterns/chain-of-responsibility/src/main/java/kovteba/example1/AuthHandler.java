package kovteba.example1;

// tag::AuthHandler[]
public class AuthHandler extends Handler {

    @Override
    protected boolean process(Request request) {
        if (!request.isAuthenticated()) {
            System.out.println("❌ Authentication failed");
            return false;
        }
        System.out.println("✔ Authentication passed");
        return true;
    }
}
// end::AuthHandler[]
