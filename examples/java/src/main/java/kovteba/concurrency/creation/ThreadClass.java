package kovteba.concurrency.creation;

// tag::ThreadClass[]
public class ThreadClass extends Thread { //extend Thread class

    private String value;

    public ThreadClass(String value) {
        this.value = value;
    }
    @Override
    public void run() {
        System.out.println("Thread with value: " + value + " is running");
    }
    public static void main(String[] args) {

        Thread thread = new ThreadClass("First"); //create instance of class
        thread.start(); // run
    }
}
// end::ThreadClass[]
