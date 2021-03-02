package sw.prp.bast.practices.ex2;

import java.io.*;
import java.util.Random;

public class Test2_bp1 {
    private static final Random random = new Random();
    private static final long[] arr = new long[100_000];

    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("bast_practices_ex_bp1.txt", true)));
        int T = 40;
        long st = System.currentTimeMillis();
        for (int i = 1; i <= T; i++) {
            init(arr);
            doSomething(arr);
        }
        long et = System.currentTimeMillis();
        out.write("#:" + args[0] + "\t" + (et - st)+"\n");
        out.close();
    }

    private static void init(long[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(1_000_000);
        }
    }
    private static void doSomething(long[] a) {
        StringBuffer ans = new StringBuffer();
        for (long l : a) {
            ans.append(l).append(' ');
        }
        System.out.print(ans.toString());
    }

}
