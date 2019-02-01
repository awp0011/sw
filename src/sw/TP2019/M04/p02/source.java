package sw.TP2019.M04.p02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class source {
    private final static int[] parent = new int[100_003];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int Q = parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        StringBuilder sb = new StringBuilder(1000);
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = parseInt(st.nextToken());
            int a = parseInt(st.nextToken());
            int b = parseInt(st.nextToken());
            if (t == 0) {
                join(a, b);
            } else {
                if (find(a) == find(b)) sb.append(1).append('\n');
                else sb.append(0).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    private static int find(int c) {
        if (parent[c] == c) return c;
        return parent[c] = find(parent[c]);
    }

    private static void join(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 != p2) parent[p2] = p1;
    }
}
