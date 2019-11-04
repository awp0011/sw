package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;

public class P1197 {
    private static int cnt;
    private static Plant[] plants;
    private static HashSet<Integer> vis = new HashSet<>();
    private static ArrayDeque<Integer> cmd = new ArrayDeque<>();
    private static ArrayDeque<Integer> ret = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        plants = new Plant[N];
        for (int i = 0; i < N; i++) plants[i] = new Plant(i);

        in.nextToken();
        int M = (int) in.nval;
        int x, y;
        for (int i = 0; i < M; i++) {
            in.nextToken();
            x = (int) in.nval;
            in.nextToken();
            y = (int) in.nval;
            if (plants[x].adj == null) plants[x].adj = new ArrayList<>();
            plants[x].adj.add(y);
            if (plants[y].adj == null) plants[y].adj = new ArrayList<>();
            plants[y].adj.add(x);
        }
        in.nextToken();
        int K = (int) in.nval;
        for (int i = 0; i < K; i++) {
            in.nextToken();
            cmd.add((int) in.nval);
            vis.add((int) in.nval);
        }

        cnt = N;
        for (int i = 0; i < N; i++) {
            if (vis.contains(i)) continue;
            for (int n : plants[i].adj) {
                if (vis.contains(n)) continue;
                union(i, n);
            }
        }
        cnt = N + N - K - cnt;
        ret.add(cnt);
        while (!cmd.isEmpty()) {
            int n = cmd.pollLast();
            vis.remove(n);
            cnt++;
            if (plants[n].adj != null) {
                continue;
            }
            for (int i : plants[n].adj) {
                if (vis.contains(i)) continue;
                union(i, n);
            }
            ret.add(cnt);

        }


        StringBuilder ans = new StringBuilder();
        while (!ret.isEmpty()) ans.append(ret.pollLast()).append('\n');
        System.out.print(ans.toString());
    }

    private static class Plant {
        int index;
        int parent;
        ArrayList<Integer> adj;

        Plant(int i) {
            index = i;
            parent = i;
        }

    }

    private static int find(int c) {
        if (plants[c].parent == c) return c;
        return plants[c].parent = find(plants[c].parent);
    }

    private static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 == p2) return;
        cnt--;
        plants[p1].parent = p2;
    }
}
