package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1120 {
    private static final int[] nums = new int[51];
    private static int ans = 0, s = 100, e = 0, total = 0;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        for (int i = 0; i < N; i++) {
            in.nextToken();
            int t = (int) in.nval;
            if (t > 50) continue;
            nums[t]++;
            total += t;
            s = Math.min(s, t);
            e = Math.max(e, t);
        }
        for (int i = e; i < total; i++) {
            if (total % i != 0) continue;
            find(total / i, 0, i, e);
            if (ans != 0) break;
        }
        if (ans == 0) ans = total;
        System.out.println(ans);
    }

    private static void find(int cnt, int sum, int len, int max) {
        if (cnt == 0) {
            System.out.println(len);
            System.exit(0);
        }
        if (sum == len) {
            find(cnt - 1, 0, len, e);
            return;
        }
        for (int i = max; i >= s; i--) {
            if (nums[i] > 0 && i + sum <= len) {
                nums[i]--;
                find(cnt, sum + i, len, i);
                nums[i]++;
                if (sum == 0 || sum + i == len) break;
            }
        }
    }

}
