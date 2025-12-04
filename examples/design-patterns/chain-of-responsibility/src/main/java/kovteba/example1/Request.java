package kovteba.example1;

// tag::Request[]
public class Request {
    private final boolean authenticated;
    private final boolean hasPermission;
    private final boolean validData;

    public Request(boolean authenticated, boolean hasPermission, boolean validData) {
        this.authenticated = authenticated;
        this.hasPermission = hasPermission;
        this.validData = validData;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public boolean hasPermission() {
        return hasPermission;
    }

    public boolean isValidData() {
        return validData;
    }
}
// end::Request[]
