package sw.adv.floyd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 弗洛伊德算法是解决任意两点间的最短路径的一种算法
 * 可以正确处理有向图或有向图或负权（但不可存在负权回路)的最短路径问题
 * 同时也被用于计算有向图的传递闭包。
 * */
import static java.lang.Math.min;
import static java.lang.Integer.parseInt;

public class Main {
    private static int N, M;
    private static int[][] d;
    private static final int INF = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        d = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                d[i][j] = (i == j) ? 0 : INF;
            }
        }
        M = parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int w = parseInt(st.nextToken());
            d[x][y] = w;
        }
        floyd();
        for (int[] e : d) {
            System.out.println(Arrays.toString(e));
        }

    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    d[i][j] = min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }

    }
}
