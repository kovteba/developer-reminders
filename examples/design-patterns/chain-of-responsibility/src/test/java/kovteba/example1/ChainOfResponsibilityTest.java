package kovteba.example1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainOfResponsibilityTest {

    @Test
    void request_fullyAuthenticated_andAuthorized_andValid_passesAllHandlers() {
        Request request = new Request(true, true, true);
        AuthHandler auth = new AuthHandler();
        PermissionHandler perm = new PermissionHandler();
        DataValidationHandler data = new DataValidationHandler();

        auth.setNext(perm).setNext(data);
        assertDoesNotThrow(() -> auth.handle(request));
    }

    @Test
    void request_notAuthenticated_stopsAtAuthHandler() {
        Request request = new Request(false, true, true);
        AuthHandler auth = new AuthHandler();
        PermissionHandler perm = new PermissionHandler();
        auth.setNext(perm);
        assertDoesNotThrow(() -> auth.handle(request));
    }

    @Test
    void request_noPermission_stopsAtPermissionHandler() {
        Request request = new Request(true, false, true);
        AuthHandler auth = new AuthHandler();
        PermissionHandler perm = new PermissionHandler();
        DataValidationHandler data = new DataValidationHandler();
        auth.setNext(perm).setNext(data);
        assertDoesNotThrow(() -> auth.handle(request));
    }

    @Test
    void request_invalidData_stopsAtDataValidationHandler() {
        Request request = new Request(true, true, false);
        AuthHandler auth = new AuthHandler();
        PermissionHandler perm = new PermissionHandler();
        DataValidationHandler data = new DataValidationHandler();
        auth.setNext(perm).setNext(data);
        assertDoesNotThrow(() -> auth.handle(request));
    }

    @Test
    void request_getters_returnCorrectValues() {
        Request r = new Request(true, false, true);
        assertTrue(r.isAuthenticated());
        assertFalse(r.hasPermission());
        assertTrue(r.isValidData());
    }

    @Test
    void handler_withNoNext_doesNotThrow() {
        Request request = new Request(true, true, true);
        AuthHandler auth = new AuthHandler();
        assertDoesNotThrow(() -> auth.handle(request));
    }
}
