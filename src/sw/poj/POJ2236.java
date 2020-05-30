package sw.poj;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class POJ2236 {
    private static int[] p;
    private static int[][] c;
    private static boolean[] vis;
    private static final HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
    private static final StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("C:\\workspace\\idea\\sw\\src\\sw\\poj\\case.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        p = new int[N + 3];
        c = new int[N + 3][2];
        vis = new boolean[N + 3];
        int d = parseInt(st.nextToken());
        d = d * d;
        for (int i = 1; i <= N; i++) {
            p[i] = i;
            st = new StringTokenizer(br.readLine());
            c[i][0] = parseInt(st.nextToken());
            c[i][1] = parseInt(st.nextToken());
            if (i == 1) continue;
            for (int j = i - 1; j >= 1; j--) {
                int dx = c[i][0] - c[j][0];
                dx = dx * dx;
                int dy = c[i][1] - c[j][1];
                dy = dy * dy;
                if (d >= dx + dy) {
                    if (!adj.containsKey(i)) adj.put(i, new ArrayList<Integer>());
                    if (!adj.containsKey(j)) adj.put(j, new ArrayList<Integer>());
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        while (br.ready()) {
            st = new StringTokenizer(br.readLine());
            char opr = st.nextToken().charAt(0);
            int p = parseInt(st.nextToken());
            if (opr == 'O') {
                repair(p);
            } else {
                int q = parseInt(st.nextToken());
                ans.append(isRepair(p, q) ? "SUCCESS" : "FAIL").append('\n');
            }
        }
        System.out.print(ans.toString());
    }


    private static void repair(int n) {
        vis[n] = true;
        if (adj.get(n) != null) {
            for (int x : adj.get(n)) {
                if (vis[x]) {
                    union(n, x);
                }
            }
        }
    }

    private static boolean isRepair(int p, int q) {
        return find(p) == find(q);
    }

    private static int find(int c) {
        if (p[c] == c) return c;
        return p[c] = find(p[c]);
    }

    private static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 != p2) {
            p[p2] = p1;
        }
    }
}
