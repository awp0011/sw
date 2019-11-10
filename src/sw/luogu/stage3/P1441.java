package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.BitSet;

public class P1441 {
    private static int N, M, ans;
    private static int[] base;
    private static boolean[] vis;
    private static BitSet set;
    private static BitSet tmp1;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval;
        base = new int[N];
        vis = new boolean[N];
        in.nextToken();
        M = (int) in.nval;

        for (int i = 0; i < N; i++) {
            in.nextToken();
            base[i] = (int) in.nval;
        }
        ans = 0;
        set = new BitSet();
        tmp1 = new BitSet();
        dfs(0, 0);
        System.out.println(ans);
    }

    private static int count() {
        set.clear();
        tmp1.clear();
        int n;
        for (int i = 0; i < N; i++) {
            if (vis[i]) continue;
            set.set(0);
            n = set.nextSetBit(0);
            while (n >= 0) {
                tmp1.set(n);
                tmp1.set(n + base[i]);
                n = set.nextSetBit(n + 1);
            }
            BitSet tmp2 = set;
            set = tmp1;
            tmp1 = tmp2;
            tmp1.clear();
        }
        return set.cardinality() - 1;
    }

    private static void dfs(int s, int cnt) {
        if (cnt == M) {
            int next = count();
            if (next > ans) ans = next;
        }
        if (M == 0) return;
        for (int i = s; i < N; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            dfs(i + 1, cnt + 1);
            vis[i] = false;
        }
    }
}
