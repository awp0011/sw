package sw.TP2019.M05.P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class source {
    private static final PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(s -> s[1]));
    private static Island[] all;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int X = parseInt(in.readLine());
        all = new Island[N + 1];
        for (int i = 0; i <= N; i++) all[i] = new Island(i);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            all[parseInt(st.nextToken())].to.add(new int[]{parseInt(st.nextToken()), parseInt(st.nextToken())});
        }
        init(1, 0);
        bfs();
        if (all[X].length == Integer.MAX_VALUE) System.out.println("NO");
        else {
            init(X, all[X].length);
            bfs();
            if (all[1].length == Integer.MAX_VALUE) System.out.println("NO");
            else {
                System.out.println("YES");
                System.out.println(all[1].length);
            }
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (all[current[0]].visited)
                all[current[0]].length = all[current[0]].length > current[1] ? current[1] : all[current[0]].length;
            else {
                all[current[0]].visited = true;
                for (int[] next : all[current[0]].to) {
                    all[next[0]].length = all[next[0]].length > next[1] + current[1] ? next[1] + current[1] : all[next[0]].length;
                    if (!all[next[0]].visited) {
                        queue.add(new int[]{next[0], all[next[0]].length});
                    }
                }
            }
        }
    }

    private static void init(int start, int initLength) {
        for (Island i : all) {
            i.length = Integer.MAX_VALUE;
            i.visited = false;
        }
        queue.add(new int[]{start, initLength});
    }

    private static class Island {
        int name;
        ArrayList<int[]> to;
        int length;
        boolean visited;

        Island(int n) {
            name = n;
            to = new ArrayList<>(20);
            visited = false;
        }

        int getLength() {
            return length;
        }
    }
}
