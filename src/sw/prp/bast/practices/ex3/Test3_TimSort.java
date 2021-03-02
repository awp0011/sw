package sw.prp.bast.practices.ex3;

import java.util.Arrays;
import java.util.Random;

public class Test3_TimSort {
    private static final long[] arr = new long[1_000_000];
    private static final Random random = new Random();

    public static void main(String[] args) {
        //System.setProperty("java.util.Arrays.useLegacyMergeSort", "false");
        int T = 1;
        long st = System.currentTimeMillis();
        for (int i = 1; i <= T; i++) {
            init();
            doSomething();
        }
        long et = System.currentTimeMillis();
        System.out.println("#:" + (args.length == 0 ? 0 : args[0]) + "\t" + (et - st));
    }

    private static void init() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1_000_000);
        }
    }

    private static void doSomething() {
        Arrays.sort(arr);
    }
}
