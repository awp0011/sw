package sw.luogu.stage5.P2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[][] cube = new int[n + 2][n + 2];
        for (int i = 0; i < n + 2; i++)  cube[i][n + 1] = -1;
        int[][] map = new int[n * n + 1][2];
        map[1][0] = 1;
        map[1][1] = 1 + n / 2;
        cube[map[1][0]][map[1][1]] = 1;

        for (int i = 2; i <= n * n; i++) {
            int pre = i - 1;
            if (map[pre][0] == 1 && map[pre][1] != n) {
                map[i][0] = n;
                map[i][1] = map[pre][1] + 1;
            } else if (map[pre][0] != 1 && map[pre][1] == n) {
                map[i][0] = map[pre][0] - 1;
                map[i][1] = 1;
            } else if (map[pre][0] == 1 && map[pre][1] == n) {
                map[i][0] = map[pre][0] + 1;
                map[i][1] = map[pre][1];
            } else {
                if (cube[map[pre][0] - 1][map[pre][1] + 1] == 0) {
                    map[i][0] = map[pre][0] - 1;
                    map[i][1] = map[pre][1] + 1;
                } else {
                    map[i][0] = map[pre][0] + 1;
                    map[i][1] = map[pre][1];
                }
            }
            cube[map[i][0]][map[i][1]] = i;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans.append(cube[i][j]).append(' ');
            }
            ans.append('\n');
        }
        System.out.println(ans.toString());
    }
}
