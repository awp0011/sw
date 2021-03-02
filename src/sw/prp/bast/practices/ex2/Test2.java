package sw.prp.bast.practices.ex2;

import java.io.*;
import java.util.Random;

public class Test2 {
    private static final Random random = new Random();
    private static final long[] arr = new long[100_000];
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("bast_practices_ex.txt", true)));
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
        for (long l : a) {
            out.print(l);
            out.print(' ');
        }
        out.flush();
    }
}
