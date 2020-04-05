package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1304 {
    private static int a = 0, b = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        for (int i = 4; i <= n; i += 2) {
            findP(i);
            ans.append(i).append('=').append(a).append('+').append(b).append('\n');
        }
        System.out.println(ans.toString());
    }

    private static void findP(int sum) {
        a = 2;
        b = sum - a;
        while (!(isP(a) && isP(b))) {
            a = nextP(a);
            b = sum - a;
        }
    }

    private static int nextP(int seed) {
        int p = seed + 1;
        while (!isP(p)) {
            if (p % 2 == 0) p += 1;
            else p += 2;
        }
        return p;
    }

    private static boolean isP(int p) {
        boolean is = true;
        for (int i = 2; i <= Math.sqrt(p); i++) {
            if (p % i == 0) {
                is = false;
                break;
            }
        }
        return is;
    }
}
