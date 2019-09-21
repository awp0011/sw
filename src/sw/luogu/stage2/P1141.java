package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P1141 {
    private static int n, m, size;
    private static boolean[][] data;
    private static boolean[] visited;
    private static int[] p, cnt;
    private static final int[][] offset = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private static final ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        size = n * n;
        data = new boolean[n][n];
        visited = new boolean[size];
        for (int i = 0; i < n; i++) {
            String ins = in.readLine();
            for (int j = 0; j < n; j++) {
                data[i][j] = (ins.charAt(j) == '0');
            }
        }
        p = new int[size];
        for (int i = 0; i < size; i++) {
            p[i] = i;
        }
        cnt = new int[size];
        Arrays.fill(cnt, 1);
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int x = parseInt(st.nextToken()) - 1;
            int y = parseInt(st.nextToken()) - 1;
            int index = x * n + y;
            if (!visited[index]) bfs(x, y);
            ans.append(cnt[find(index)]).append('\n');
        }
        System.out.println(ans.toString());
    }

    private static void bfs(int x, int y) {
        int index = x * n + y;
        visited[index] = true;
        queue.add(index);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            int i = start / n;
            int j = start % n;
            for (int[] next : offset) {
                int nextX = i + next[0];
                int nextY = j + next[1];
                if (nextX < 0 || nextX >= n) continue;
                if (nextY < 0 || nextY >= n) continue;
                int nextI = nextX * n + nextY;
                if (!visited[nextI] && data[i][j] != data[nextX][nextY]) {
                    visited[nextI] = true;
                    union(start, nextI);
                    queue.add(nextI);
                }
            }
        }
    }

    private static int find(int c) {
        if (c == p[c]) return c;
        return p[c] = find(p[c]);
    }

    private static void union(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 == p2) return;
        if (p1 > p2) {
            p[p1] = p2;
            cnt[p2] += cnt[p1];
        } else {
            p[p2] = p1;
            cnt[p1] += cnt[p2];
        }
    }
}
