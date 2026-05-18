package kovteba.core;

// tag::ForkJoinPoolImplementation[]
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolImplementation extends RecursiveTask<Integer> {

    private final int[] array;
    private final int start;
    private final int end;

    public ForkJoinPoolImplementation(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 3) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Разбиваем задачу на две подзадачи и выполняем их параллельно
            int middle = (start + end) / 2;
            ForkJoinPoolImplementation leftTask = new ForkJoinPoolImplementation(array, start, middle);
            ForkJoinPoolImplementation rightTask = new ForkJoinPoolImplementation(array, middle + 1, end);

            leftTask.fork(); // Асинхронно запускаем левую подзадачу
            int rightResult = rightTask.compute(); // Выполняем правую подзадачу (может выполняться рекурсивно)
            int leftResult = leftTask.join(); // Ожидаем завершения левой подзадачи и получаем ее результат

            // Объединяем результаты левой и правой подзадач
            return leftResult + rightResult;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int result = forkJoinPool.invoke(new ForkJoinPoolImplementation(array, 0, array.length - 1));
        System.out.println("Результат: " + result);
    }
}
// end::ForkJoinPoolImplementation[]
