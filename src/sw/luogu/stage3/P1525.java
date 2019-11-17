package sw.luogu.stage3;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class P1525 {
    private static int[] p, r;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata (2).in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) p[i] = i;
        r = new int[n + 1];

        in.nextToken();
        int m = (int) in.nval;
        int[][] du = new int[m+1][3];
        for (int i = 0; i < m; i++) {
            in.nextToken();
            du[i][0] = (int) in.nval;
            in.nextToken();
            du[i][1] = (int) in.nval;
            in.nextToken();
            du[i][2] = (int) in.nval;

        }
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Arrays.sort(du, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[2] - o1[2];
            }
        });
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            if (check(du[i][0], du[i][1])) {
                ans = du[i][2];
                break;
            } else {
                if (r[du[i][0]] == 0) r[du[i][0]] = du[i][1];//标记“敌人”
                else {
                    union(r[du[i][0]], du[i][1]);
                }//将敌人的敌人合并
                if (r[du[i][1]] == 0) r[du[i][1]] = du[i][0];
                else {
                    union(r[du[i][1]], du[i][0]);
                }
            }
        }
        System.out.println(ans);
    }

    private static int find(int c) {
        if (p[c] == c) return c;
        return p[c] = find(p[c]);
    }

    private static boolean check(int c1, int c2) {
        return find(c1) == find(c2);
    }

    private static void union(int c1, int c2) {
        p[find(c1)] = find(c2);
    }
}

