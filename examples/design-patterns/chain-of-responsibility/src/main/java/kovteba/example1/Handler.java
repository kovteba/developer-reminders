package kovteba.example1;

// tag::Handler[]
public abstract class Handler {

    private Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public void handle(Request request) {
        if (process(request) && next != null) {
            next.handle(request);
        }
    }

    protected abstract boolean process(Request request);
}
// end::Handler[]
