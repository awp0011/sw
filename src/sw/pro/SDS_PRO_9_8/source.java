package sw.pro.SDS_PRO_9_8;
//https://koitp.org/problem/TWICE_PICK/read/

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Math.max;

class source {
    static int[][] map = new int[105][105];
    static int[][][][] dp = new int[105][105][105][105];
    static int T, M, N;
    static char PAPER = '*';
    static char EMPTY = '.';
    static char SHARP = '#';

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        String[] tempArr;
        char[] tempCharArr;
        for (int tc = 0; tc < T; tc++) {

            tempArr = br.readLine().trim().split(" ");
            N = Integer.parseInt(tempArr[0]);
            M = Integer.parseInt(tempArr[1]);
            for (int i = 1; i <= M; i++) {
                tempCharArr = br.readLine().trim().toCharArray();
                for (int j = 1; j <= N; j++) {
                    if (tempCharArr[j - 1] == PAPER) map[i][j] = 1;
                    else if (tempCharArr[j - 1] == EMPTY) map[i][j] = 0;
                    else map[i][j] = -1;
                }
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[i][j] == -1) continue;
                    for (int k = i + 1; k <= N; k++) {
                        for (int l = 1; l < j; l++) {
                            if (map[k][l] == -1) continue;
                            dp[i][j][k][l] = max4(
                                    dp[i][j - 1][k][l - 1],
                                    dp[i][j - 1][k - 1][l],
                                    dp[i - 1][j][k - 1][l],
                                    dp[i - 1][j][k][l - 1]
                            ) + map[i][j] + map[k][l];
                        }
                    }
                }
            }
            System.out.println(dp[N - 1][M][N][M - 1] + (map[N][M] == 1 ? 1 : 0));
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    for (int k = 1; k <= N; k++) {
                        for (int l = 1; l <= M; l++) {
                            dp[i][j][k][l] = 0;
                        }
                    }
                }
            }
        }


    }

    private static int max4(int one, int two, int three, int four) {
        return max(max(one, two), max(three, four));
    }

}
