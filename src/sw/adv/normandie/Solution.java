package sw.adv.normandie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        //简单测试法:
        long startTime = System.currentTimeMillis();
        //获取开始时间

        for (int t = 1; t <= T; t++) {


            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][][] map = new int[N + 2][N + 2][2];
            int x, y, z;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                z = Integer.parseInt(st.nextToken());
                if (x >= z && (x % z) == 0) map[x][y][1] = 1;

            }
            map[1][1][0] = 1;
            for (int i = 1; i < N; i++) {
                for (int j = 1; j <= i + 1; j++) {
                    if (map[i][j][1] == 0) {
                        map[i + 1][j][0] += map[i][j][0];
                        map[i + 1][j + 1][0] += map[i][j][0];
                    }
                }
            }
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                answer += map[N][i][0];
            }
            System.out.println("#" + t + " " + answer);
        }
        //TO-Do
        long endTime = System.currentTimeMillis();
        //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}