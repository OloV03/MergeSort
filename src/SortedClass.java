import java.util.Arrays;

public class SortedClass {
    public static void main(String[] args) {
        int x = 100000; // кол-во элементов
        int p = 2;      // кол-во используемых потоков
        double[] src = Utils.getArray(x);

        // Ассинхронный вариант
        new ParallSort(Arrays.copyOf(src, x)).main(p);

        // Синхронный вариант
        new SimpleSort(Arrays.copyOf(src, x)).main();
    }
}