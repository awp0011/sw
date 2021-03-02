package sw.prp.bast.practices.ex1;


import java.util.Random;

public class Test1_bp3 {

    public static void main(String[] args) throws Exception {
        int T = 40;
        long st = System.currentTimeMillis();
        for (int i = 1; i <= T; i++) {
            long[][] arr = new long[1_000_000][2];
            init(arr);
            long ans = doSomething(arr);
            //System.out.println("#" + i + " " + ans);
        }
        long et = System.currentTimeMillis();
        System.out.println("#:" + args[0] + "\t" + (et - st));
    }

    private static void init(long[][] a) {
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i][0] = random.nextInt(1_000_000);
            a[i][1] = random.nextInt(1_000_000);
        }
    }

    private static long doSomething(long[][] a) {
        int MOD = 1_000_000_007;
        for (int i = 1; i < a.length; i++) {
            a[i][0] += a[i][1];
            a[i][0] %= MOD;
            a[i][0] += a[i - 1][0];
            a[i][0] %= MOD;
        }
        return (a[a.length - 1][0] + a[a.length - 1][1]) % MOD;
    }

}

