package sw.pro.USACO_2017FEB_SILVER_COWPARTY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    private static int[][] shortest;
    private static int[][] visited;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] first = new int[N + 1][N + 1];
        int[][] second = new int[N + 1][N + 1];
        shortest = new int[2][N + 1];
        visited = new int[2][N + 1];
        visited[0][0] = 1;
        visited[1][0] = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int Ai = Integer.parseInt(st.nextToken());
            int Bi = Integer.parseInt(st.nextToken());
            int Ti = Integer.parseInt(st.nextToken());
            first[Ai][Bi] = Ti;
            second[Bi][Ai] = Ti;
        }
        Arrays.fill(shortest[0], Integer.MAX_VALUE);
        Arrays.fill(shortest[1], Integer.MAX_VALUE);
        shortest[0][X] = 0;
        shortest[1][X] = 0;
        bfs(X, 0, first);
        bfs(X, 1, second);
        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, shortest[0][i] + shortest[1][i]);
        }
        System.out.println(max);

    }

    private static void bfs(int start, int flag, int[][] edge_set) {
        int next = start;
        visited[flag][next] = 1;
        for (int k = 1; k < N; k++) {
            for (int i = 1; i <= N; i++) {
                if (i == start) continue;
                if (edge_set[next][i] > 0) {
                    shortest[flag][i] = Math.min(shortest[flag][i], shortest[flag][next] + edge_set[next][i]);
                }
            }
            int existed = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) {//next is current shortest
                if (visited[flag][i] == 0 && shortest[flag][i] <= existed) {
                    next = i;
                    existed = shortest[flag][i];
                }
            }
            visited[flag][next] = 1;

        }
        //while (Arrays.stream(visited[flag]).anyMatch(s -> s == 0));
    }
}