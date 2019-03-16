package sw.pro.COI_2015_KOVANICE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class source2 {
    private static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        ArrayList<Pair> e = new ArrayList<>(3000);
        //B = new HashMap<>(3000);
        Map<Integer, ArrayList<Integer>> d1 = new HashMap<>(3000);
        Map<Integer, ArrayList<Integer>> r1 = new HashMap<>(3000);
        parents = new int[m + 5];
        for (int i = 1; i < m + 1; i++) {
            parents[i] = i;
        }
        int[] d = new int[m + 5];
        int[] r = new int[m + 5];
        String tc;
        int a, b;
        for (int i = 0; i < v; i++) {
            tc = bf.readLine();
            int pos = tc.indexOf("=");

            if (pos > 0) {
                st = new StringTokenizer(tc, "=");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                union(a, b);
            } else {
                st = new StringTokenizer(tc, "<");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                e.add(new Pair(a, b));
            }
        }

        for (Pair p : e) {
            d1.computeIfAbsent(find(parents[p.first]), k -> new ArrayList<>()).add(find(parents[p.second]));
            r1.computeIfAbsent(parents[p.second], k -> new ArrayList<>()).add(parents[p.first]);
        }
        for (int i = 1; i < m + 1; i++) {
            dfs(find(parents[i]), d1, d);
        }
        for (int i = 1; i < m + 1; i++) {
            dfs(find(parents[i]), r1, r);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < m + 1; i++) {
            if (d[parents[i]] + r[parents[i]] - 1 == n) {
                sb.append('K').append(r[parents[i]]).append('\n');
            } else {
                sb.append('?').append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    private static int find(int c) {
        if (parents[c] == c) return c;
        return parents[c] = find(parents[c]);
    }

    private static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 < p2) parents[p2] = parents[p1];
        else parents[p1] = parents[p2];
    }


    private static int dfs(int i, Map<Integer, ArrayList<Integer>> D, int[] d) {
        if (d[i] != 0) return d[i];
        if (D.get(i) != null) {
            for (int j : D.get(i)) d[i] = Math.max(d[i], dfs(j, D, d));
        }
        return ++d[i];
    }

    private static class Pair {
        int first, second;

        Pair(final int f, final int s) {
            first = f;
            second = s;
        }
    }


}