public class QuicksortJava {

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort1(int[] a, int l, int r) {
        int m = a[(l + r) / 2];
        int i = l;
        int j = r;
        while (i <= j) {
            while (a[i] < m) i++;
            while (a[j] > m) j--;
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        if (l < j) sort1(a, l, j);
        if (r > i) sort1(a, i, r);
    }

    public static void quicksort(int[] a) {
        sort1(a, 0, a.length - 1);
    }

    public static long calcBest(int[] a) {
        long best = Long.MAX_VALUE;

        for (int i = 0; i < 10; i++) {
            long t1 = System.currentTimeMillis();
            quicksort(a);
            long t2 = System.currentTimeMillis();
            best = Math.min(t2 - t1, best);
        }

        return best;
    }

    public static void main(String[] args) {
        int[] a = new int[2000000*1];
        for (int i = 0; i < a.length; i++) {
            a[i] = i * 3 / 2 + 1;
            if (i % 3 == 0) a[i] = -a[i];
        }

        System.out.println(calcBest(a));
    }
}
