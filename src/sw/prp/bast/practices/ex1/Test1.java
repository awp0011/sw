package sw.prp.bast.practices.ex1;


import java.util.Random;

public class Test1 {
    private static final int MOD = 1_000_000_007;
    private static final long[][] arr = new long[2][1_000_000];
    private static final Random random = new Random();

    public static void main(String[] args) throws Exception {
        int T = 40;
        long st = System.currentTimeMillis();
        for (int i = 1; i <= T; i++) {
            init(arr);
            long ans = doSomething(arr);
            //System.out.println("#" + i + " " + ans);
        }
        long et = System.currentTimeMillis();
        System.out.println("#:" + args[0] + "\t" + (et - st));
    }

    private static void init(long[][] a) {
        for (int i = 0; i < a.length; i++) {
            a[0][i] = random.nextInt(1_000_000);
            a[1][i] = random.nextInt(1_000_000);
        }
    }

    private static long doSomething(long[][] a) {
        for (int i = 1; i < a.length; i++) {
            a[0][i] += a[0][i - 1];
            a[0][i] %= MOD;
            a[1][i] += a[1][i - 1];
            a[1][i] %= MOD;
        }
        return (a[0][a.length - 1] + a[1][a.length - 1]) % MOD;
    }

}

