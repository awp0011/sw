package sw.luogu.stage5.P5732;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[][] map = new int[n + 2][n + 2];
        map[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                map[i + 1][j + 1] += map[i][j];
                map[i + 1][j] += map[i][j];
                System.out.print(map[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
}
