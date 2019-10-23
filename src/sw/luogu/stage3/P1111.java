package sw.luogu.stage3;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class P1111 {
    private static int[][] d;
    private static int N, M;
    private static int[] p;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata (9).in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval;
        p = new int[N + 5];
        for (int i = 1; i <= N; i++) {
            p[i] = i;
        }
        in.nextToken();
        M = (int) in.nval;
        d = new int[M][3];

        for (int i = 0; i < M; i++) {
            in.nextToken();
            d[i][0] = (int) in.nval;
            in.nextToken();
            d[i][1] = (int) in.nval;
            in.nextToken();
            d[i][2] = (int) in.nval;
        }
        System.setProperty("java.util.Arrays.useLegacyMergeSort","true");
        Arrays.sort(d, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        int index = 0, ans = -1, cnt = 0;
        while (index <= M && cnt < N - 1) {
            System.out.println(Arrays.toString(d[index]));
            if (union(d[index][0], d[index][1])) {
                ans = d[index][2];
                cnt++;
            }
            index++;
        }
        System.out.println(cnt == N - 1 ? ans : -1);

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
