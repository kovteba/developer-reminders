// tag::PatternMatching2[]
record Point(int x, int y) {}


public void printPoint(Object obj) {
    if (obj instanceof Point(int x, int y)) {
        System.out.println("Координати: x=" + x + ", y=" + y);
    }
}
// end::PatternMatching2[]

public void main() {
}
