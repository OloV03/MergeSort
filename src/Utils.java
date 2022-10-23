import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    private static List<double[]> list = new ArrayList<>();
    public synchronized static void addArray(double[] array) {
        list.add(array);
    }


    // вспомонагательный метод
    public static double[] merge() {
        double[] a = new double[0];

        int i = 0;
        while (list.size() > 0) {
            double[] array = list.get(i);
            list.remove(array);
            a = merge(a, array);
        }
        return a;
    }


    /**
     * Метод слияния массивов left и right
     * @param left массив типа double
     * @param right массив типа double
     * @return объединенный массив
     */
    public static double[] merge(double[] left, double[] right) {
        double[] rsl = new double[left.length + right.length];
        int i = 0, j = 0, k = 0;
        int ll = left.length, rl = right.length;

        while (i < ll && j < rl) {
            if (left[i] < right[j]) {
                rsl[k++] = left[i++];
            } else {
                rsl[k++] = right[j++];
            }
        }
        while (i < ll) {
            rsl[k++] = left[i++];
        }

        while (j < rl) {
            rsl[k++] = right[j++];
        }
        return rsl;
    }


    /**
     * Сортировка слиянием входящего массив
     * @param a массив для сортировки
     */
    public static void mergeSort(double[] a) {
        int n = a.length;
        if (n < 2) return;

        int mid = n / 2;
        double[] left = new double[mid];
        double[] right = new double[n - mid];

        System.arraycopy(a, 0, left, 0, mid);
        System.arraycopy(a, mid, right, 0, n-mid);

        mergeSort(left);
        mergeSort(right);

        merge(a, left, right, mid, n - mid);
    }

    /** Слиение массивов
     * @param a исходный массив
     * @param l левая часть массива
     * @param r правая часть массива
     * @param left индекс начала
     * @param right индекс конца
     */
    public static void merge(double[] a, double[] l, double[] r,
                             int left, int right) {
        int i = 0, j = 0, k = 0;

        while (i < left && j < right) {
            if (l[i] <= r[j])
                a[k++] = l[i++];
            else
                a[k++] = r[j++];
        }

        while (i < left)
            a[k++] = l[i++];
        while (j < right)
            a[k++] = r[j++];
    }

    /**
     * Получение массива, заполненного случайными числами
     * @param x кол-во элементов массива
     * @return массив случайных чисел (0,1000)
     */
    public static double[] getArray(int x) {
        double[] res = new double[x];
        for (int i = 0; i < x; i++) {
            res[i] = Math.random() * 100;
        }
        return res;
    }
}