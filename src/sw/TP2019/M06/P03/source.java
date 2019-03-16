package sw.TP2019.M06.P03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][][] map = new int[N+1][N+1][2];
        StringTokenizer st;
        for (int i = 1; i <=N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=N ; j++) {
                map[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
