package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P2024 {
    private static int[] p;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        p = new int[N + 5];
        for (int i = 1; i <= N; i++) p[i] = i;
        in.nextToken();
        int K = (int) in.nval;

        int z, x, y, cnt = 0;
        for (int i = 0; i < K; i++) {
            in.nextToken();
            z = (int) in.nval;
            in.nextToken();
            x = (int) in.nval;
            in.nextToken();
            y = (int) in.nval;
            if (x > N || y > N) {
                cnt++;
            } else {
                if (z == 1) {
                    if (find(x) != find(y)) cnt++;
                } else {
                    if (find(x) == find(y)) cnt++;
                    else {

                    }
                }
            }

        }
    }

    static int find(int c) {
        if (p[c] == c) return c;
        return p[c] = find(p[c]);
    }

    static boolean union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 == p2) return false;
        if (p1 < p2) p[p2] = p1;
        else p[p1] = p2;
        return true;
    }
}
