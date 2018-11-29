package sw.pro.shields.up;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Solution {
    private final static int[][][] dp = new int[1003][1003][3];//0:shields; 1:shortest; 2:isVisited
    private final static int[][] offsets = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private final static Queue<int[]> queue = new ArrayDeque<>(2000);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken());
            int M = parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                String line = br.readLine();
                for (int j = 1; j <= M; j++) {
                    dp[i][j][0] = line.charAt(j - 1) - '0';
                    if (dp[i][j][0] == 0 || i == 1 || j == 1 || i == N || j == M) {
                        dp[i][j][1] = dp[i][j][0];
                        dp[i][j][0] = 0;
                        dp[i][j][2] = 0;
                        queue.offer(new int[]{i, j});
                    } else {
                        dp[i][j][1] = MAX_VALUE;
                        dp[i][j][2] = 1;
                    }

                }
            }
            while (!queue.isEmpty() && queue.peek() != null) {
                int[] current = queue.poll();
                //System.out.println("<--"+Arrays.toString(current));
                dp[current[0]][current[1]][0] = 0;
                for (int[] offset : offsets) {
                    int nextX = current[0] + offset[0];
                    int nextY = current[1] + offset[1];
                    if (dp[nextX][nextY][2] == 1) {
                        dp[nextX][nextY][2] = 0;
                        queue.offer(new int[]{nextX, nextY});
                        //System.out.println("-->"+Arrays.toString(new int[]{nextX, nextX}));
                    }
                    dp[nextX][nextY][1] = min(dp[nextX][nextY][1],
                            dp[current[0]][current[1]][1] + dp[nextX][nextY][0]);
                }
            }
            int sum = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    sum += dp[i][j][1];
                }
            }
            System.out.println("#" + t + " " + sum);
        }

    }

}
