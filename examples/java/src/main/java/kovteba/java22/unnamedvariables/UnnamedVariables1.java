
// tag::UnnamedVariables1[]
record Point(int x, int y) {}

public static void main(String[] args) {
    Object obj = new Point(10, 20);

    if (obj instanceof Point(int x, _)) { // Нам цікавий тільки x
        System.out.println("Координата X: " + x);
    }
}
// end::UnnamedVariables1[]
