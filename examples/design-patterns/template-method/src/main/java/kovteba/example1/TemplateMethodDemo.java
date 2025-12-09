package kovteba.example1;

// tag::TemplateMethodDemo[]
public class TemplateMethodDemo {

    public static void main(String[] args) {

        Beverage tea = new Tea();
        System.out.println("=== Making Tea ===");
        tea.prepareBeverage();

        System.out.println();

        Beverage coffee = new Coffee();
        System.out.println("=== Making Coffee ===");
        coffee.prepareBeverage();
    }
}
// end::TemplateMethodDemo[]
/*
// tag::TemplateMethodDemoResult[]
=== Making Tea ===
Boiling water...
Steeping the tea...
Pouring into cup...
Adding lemon...

=== Making Coffee ===
Boiling water...
Dripping coffee through filter...
Pouring into cup...
Adding sugar and milk...
// end::TemplateMethodDemoResult[]
 */
