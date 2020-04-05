package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1319 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        int[][] map = new int[N][N];
        int cnt = 0, val = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                while (cnt == 0) {
                    in.nextToken();
                    cnt = (int) in.nval;
                    val = (val + 1) % 2;
                }
                map[i][j] = val;
                cnt--;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
