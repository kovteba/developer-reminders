package kovteba.example1;

// tag::PermissionHandler[]
public class PermissionHandler extends Handler {

    @Override
    protected boolean process(Request request) {
        if (!request.hasPermission()) {
            System.out.println("❌ Permission denied");
            return false;
        }
        System.out.println("✔ Permission granted");
        return true;
    }
}
// end::PermissionHandler[]
