package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1908PRO {
    public static int n;
    public static final int MAX = 1_000_005;
    public static int tree[] = new int[MAX];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        int arr[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            update(arr[i - 1], 1);
            ans += (i - sum(i - 1));
        }
        System.out.println(ans);
    }

    private static long sum(int x) {
        long sum = 0;
        while (x > 0) {
            sum += tree[x];
            x -= lowbit(x);
        }
        return sum;
    }

    private static void update(int i, int x) {
        while (i <= MAX) {
            tree[i] += x;
            i += lowbit(i);
        }
    }

    private static int lowbit(int x) {
        return x & (-x);
    }

}