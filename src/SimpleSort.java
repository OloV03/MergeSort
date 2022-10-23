import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class SimpleSort {
    double[] arr; // Исходный массив

    public SimpleSort(double[] arr) {
        this.arr = arr;
    }

    public void main() {
        Instant start = Instant.now();
        Utils.mergeSort(arr);
        Instant end = Instant.now();
        System.out.println("Time: " + Duration.between(start, end).toMillis() + " ms");
    }
}
