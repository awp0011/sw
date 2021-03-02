package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution20210301 {
    private static final int[][] next = new int[][]{
            {-1, -2}, {1, -2}, {-1, 2}, {1, 2}, {-2, -1}, {2, -1}, {-2, 1}, {2, 1}
    };
    private static final int INF = Integer.MAX_VALUE >> 1;
    private static final int[] map = new int[250005];
    private static final int[] dist = new int[250005];
    private static final int[] cnt = new int[250005];
    private static int N, M;

    private static final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> dist[o]));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int S = 0, E = 0;
            for (int i = 0; i < N; i++) {
                char[] line = br.readLine().toCharArray();
                for (int j = 0; j < M; j++) {
                    int pos = i * M + j;
                    if (line[j] == '.') {
                        map[pos] = 1;
                    } else if (line[j] == '#') {
                        map[pos] = INF;
                    } else if (line[j] == 'R') {
                        map[pos] = 0;
                    } else if (line[j] == 'S') {
                        map[pos] = INF;
                        S = pos;
                    } else if (line[j] == 'E') {
                        map[pos] = 1;
                        E = pos;
                    }
                }
            }
            dijkstra(S);
            if (dist[E] == INF) System.out.println("#" + t + " -1");
            else System.out.println("#" + t + " " + dist[E] + " " + cnt[E]);
        }
    }

    static void dijkstra(int s) {
        Arrays.fill(dist, INF);
        Arrays.fill(cnt, 0);
        pq.add(s);
        dist[s] = 0;
        cnt[s] = 1;
        while (!pq.isEmpty()) {
            int from = pq.poll();
            int x = from / M;
            int y = from % M;
            for (int[] offset : next) {
                int nX = x + offset[0];
                if (nX < 0 || nX >= N) continue;
                int nY = y + offset[1];
                if (nY < 0 || nY >= M) continue;
                int to = nX * M + nY;
                if (dist[to] > dist[from] + map[to]) {
                    dist[to] = dist[from] + map[to];
                    cnt[to] = cnt[from];
                    pq.add(to);
                } else if (dist[to] == dist[from] + map[to]) {
                    cnt[to] += cnt[from];
                    pq.add(to);
                }
            }
        }
    }
}
