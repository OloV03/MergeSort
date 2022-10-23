import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class ParallSort {
    private double[] arr;

    public ParallSort(double[] arr) {
        this.arr = arr;
    }

    public void main(int p) {
        int countElements = arr.length / p;
        for (int i = 0; i < p; i++) {
            int finalI = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    double[] a = new double[countElements];
                    System.arraycopy(arr, countElements * finalI, a, 0, countElements);
                    Utils.mergeSort(a);
                    Utils.addArray(a);
                }
            });
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Instant start = Instant.now();
        arr = Utils.merge();
        Instant end = Instant.now();
        System.out.println("Time Parallels: " + Duration.between(start, end).toMillis() + " ms");
    }
}