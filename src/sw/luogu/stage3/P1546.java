package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1546 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        int cnt = (N * N) >> 1;
        int[][] edges = new int[cnt][3];
        int index = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                in.nextToken();
                if (i == j) continue;
                if (i > j) continue;
                edges[index][0] = i;
                edges[index][1] = j;
                edges[index][2] = (int) in.nval;
                index++;
            }
        }
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Arrays.sort(edges, 0, index, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int[] p = new int[N + 1];
        for (int i = 1; i <= N; i++) p[i] = i;
        int sum = 0;
        cnt = 0;
        for (int i = 0; i < index && cnt < N - 1; i++) {
            if (union(edges[i][1], edges[i][0], p)) {
                cnt++;
                sum += edges[i][2];
            }
        }
        System.out.println(sum);

    }

    private static int find(int c, int[] p) {
        if (p[c] == c) return c;
        return p[c] = find(p[c], p);
    }

    static boolean union(int c1, int c2, int[] p) {
        int p1 = find(c1, p);
        int p2 = find(c2, p);
        if (p1 == p2) return false;
        if (p1 < p2) p[p2] = p1;
        else p[p1] = p2;
        return true;
    }
}
