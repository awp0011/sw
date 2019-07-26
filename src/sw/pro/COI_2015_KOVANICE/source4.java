package sw.pro.COI_2015_KOVANICE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class source4 {
    private static Map<Integer, ArrayList<Integer>> B;
    private static int[] com;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        ArrayList<Pair> e = new ArrayList<>();
        B = new HashMap<>(3000);
        Map<Integer, ArrayList<Integer>> d1 = new HashMap<>();
        Map<Integer, ArrayList<Integer>> r1 = new HashMap<>();
        com = new int[m + 5];
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
                B.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
                B.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            } else {
                st = new StringTokenizer(tc, "<");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                e.add(new Pair(a, b));
            }
        }
        for (int i = 1; i < m + 1; i++) {
            if (com[i] == 0) mark(i, i);
        }
        for (Pair p : e) {
            d1.computeIfAbsent(com[p.first], k -> new ArrayList<>()).add(com[p.second]);
            r1.computeIfAbsent(com[p.second], k -> new ArrayList<>()).add(com[p.first]);
        }
        for (int i = 1; i < m + 1; i++) {
            dfs(com[i], d1, d);
        }
        for (int i = 1; i < m + 1; i++) {
            dfs(com[i], r1, r);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < m + 1; i++) {
            if (d[com[i]] + r[com[i]] - 1 == n) {
                sb.append( 'K' ).append(r[com[i]]).append('\n');
            } else {
                sb.append( '?').append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    private static void mark(int i, int c) {
        if (com[i] > 0) return;
        com[i] = c;
        if (B.get(i) != null) {
            for (int j : B.get(i))
                mark(j, c);
        }
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
