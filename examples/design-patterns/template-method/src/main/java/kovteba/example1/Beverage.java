package kovteba.example1;

// tag::Beverage[]
public abstract class Beverage {

    // Template Method — визначає послідовність виконання
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourIntoCup();

        if (shouldAddCondiments()) {
            addCondiments();
        }
    }

    private void boilWater() {
        System.out.println("Boiling water...");
    }

    private void pourIntoCup() {
        System.out.println("Pouring into cup...");
    }

    // Кроки, які визначають підкласи:
    protected abstract void brew();
    protected abstract void addCondiments();

    // Хук — підкласи можуть перевизначити (не обов’язково)
    protected boolean shouldAddCondiments() {
        return true;
    }
}
// end::Beverage[]
