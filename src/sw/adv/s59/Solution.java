package sw.adv.s59;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    private static final char[][][] pics = new char[10][5][10];
    private static final int[][][] map = new int[10][10][2];
    private static final boolean[] isVisited = new boolean[10];
    private static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {

            for (int k = 0; k < 10; k++) {
                for (int i = 0; i < 5; i++) {
                    String tc = sc.next();
                    for (int j = 0; j < 10; j++) {
                        pics[k][i][j] = tc.charAt(j);
                    }
                }
                if (k > 0) find(k);
            }

            ans = 0;
            for (int i = 0; i < 10; i++) {
                dfs(i, 1, 0);
                if (ans == 10) break;
                dfs(i, 1, 1);
                if (ans == 10) break;
            }

            System.out.println("#" + t + " " + ans);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    map[i][j][0] = 0;
                    map[i][j][1] = 0;
                }
            }
        }
    }

    private static void dfs(int s, int cnt, int rl) {
        isVisited[s] = true;
        if (cnt > ans) ans = cnt;
        for (int i = 0; i < 10; i++) {
            if (!isVisited[i] || map[s][i][rl] == 1) dfs(i, cnt + 1, (rl + 1) % 2);
        }
        isVisited[s] = false;
    }

    private static void find(int n) {

        for (int i = n - 1; i >= 0; i--) {
            if (isSame(n, i, 0)) {
                map[n][i][0] = 1;
                map[i][n][1] = 1;
            }
            if (isSame(n, i, 6)) {
                map[n][i][1] = 1;
                map[i][n][0] = 1;
            }
        }


    }

    private static boolean isSame(int n1, int n2, int start) {
        int cnt = 0, start2 = 0;
        if (start == 0) start2 = 6;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                if (pics[n1][i][j + start] == pics[n2][i][j + start2]) cnt++;
            }
        }
        return cnt >= 16;
    }
}
