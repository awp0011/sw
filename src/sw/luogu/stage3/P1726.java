package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1726 {
    private static int[] p1, p2, cnt;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata (4).in"));

        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        in.nextToken();
        int M = (int) in.nval;

        p1 = new int[N + 1];
        p2 = new int[N + 1];
        cnt = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            p1[i] = p2[i] = i;
            cnt[i] = 1;
        }
        int a, b, t;
        for (int i = 0; i < M; i++) {
            in.nextToken();
            a = (int) in.nval;
            in.nextToken();
            b = (int) in.nval;
            in.nextToken();
            t = (int) in.nval;
            if (t == 2) {
                union2(a, b);
            } else {
                if (find(a, p1) == find(b, p1)) {
                    union2(a, b);
                }
            }
            union1(a, b);
        }

        int parent = 1, max = cnt[1];
        for (int i = 2; i <= N; i++) {
            if (max < cnt[i]) {
                parent = i;
                max = cnt[i];
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (find(i, p2) == parent) ans.append(i).append(' ');
        }
        System.out.println(max);
        System.out.println(ans.toString());
    }

    private static int find(int c, int[] p) {
        if (p[c] == c) return c;
        return p[c] = find(p[c], p);
    }

    private static void union1(int c1, int c2) {
        int q1 = find(c1, p1);
        int q2 = find(c2, p1);
        if (q1 == q2) return;
        if (q1 < q2) p1[q2] = q1;
        else p1[q1] = q2;
    }

    private static void union2(int c1, int c2) {
        int q1 = find(c1, p2);
        int q2 = find(c2, p2);
        if (q1 == q2) return;
        if (q1 < q2) {
            p2[q2] = q1;
            cnt[q1] += cnt[q2];
        } else {
            p2[q1] = q2;
            cnt[q2] += cnt[q1];
        }

    }
}
