package sw.pro.USACO_2017FEB_SILVER_COWPARTY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Batter {
    private static int[][] way = new int[1111][1111];
    private static int[][] nay = new int[1111][1111];
    private static int[] dist1 = new int[1111];
    private static int[] dist2 = new int[1111];
    private static int[] vis1 = new int[1111];
    private static int[] vis2 = new int[1111];
    private static int inf = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        for (int i=1;i<=M;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            way[a][b] = c;
            nay[b][a] = c;
        }
        for (int i=1;i<=N;i++) dist1[i] = dist2[i] = inf;
        dist1[X] = dist2[X] = 0;
        for (int i=1;i<=N;i++) {
            int k = -1, d = inf;
            for (int j=1;j<=N;j++) {
                if (vis1[j]==0 && dist1[j] <= d) {
                    d = dist1[j];
                    k = j;
                }
            }
            vis1[k] = 1;
            for (int j=1;j<=N;j++) {
                if (way[k][j]==0) continue;
                dist1[j] = minf(dist1[j], d + way[k][j]);
            }
        }
        for (int i=1;i<=N;i++) {
            int k = -1, d = inf;
            for (int j=1;j<=N;j++) {
                if (vis2[j]==0 && dist2[j] <= d) {
                    d = dist2[j];
                    k = j;
                }
            }
            vis2[k] = 1;
            for (int j=1;j<=N;j++) {
                if (nay[k][j]==0) continue;
                dist2[j] = minf(dist2[j], d + nay[k][j]);
            }
        }
        int ans = 0;
        for (int i=1;i<=N;i++) ans = maxf(ans, dist1[i] + dist2[i]);
        System.out.println(ans);
    }

    private static int maxf(int a, int b){
        return ((a)>(b)?(a):(b));
    }

    private static int minf(int a, int b){
        return  ((a)<(b)?(a):(b));
    }
}