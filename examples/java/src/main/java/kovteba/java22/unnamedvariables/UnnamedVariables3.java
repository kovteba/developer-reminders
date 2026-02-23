package kovteba.java22.unnamedvariables;

// tag::UnnamedVariables3[]
public class UnnamedVariables3 {
    public static void main(String[] args) {
        String userInput = "abc"; // Припустимо, користувач ввів некоректне число
        try {
            int number = Integer.parseInt(userInput);
        } catch (NumberFormatException _) { // Нам байдуже на деталі помилки
            System.out.println("Будь ласка, введіть число!");
        }
    }
}
// end::UnnamedVariables3[]
