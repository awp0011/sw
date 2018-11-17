package sw.adv.slash.burn;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private final static int[][] map = new int[1001][1001];
    private final static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long startTime = System.currentTimeMillis();
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Sx = Integer.parseInt(st.nextToken());
            int Sy = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = line.charAt(j);
                }
            }
            queue.add(new int[]{Sx, Sy});
            map[Sx][Sy] = 0;
            int time = 0;
            while (!queue.isEmpty()) {
                int[] next = queue.poll();
                int g = 'G';
                if (next[0] > 0 && map[next[0] - 1][next[1]] == g) {
                    queue.add(new int[]{next[0] - 1, next[1]});
                    map[next[0] - 1][next[1]] = map[next[0]][next[1]] - 1;
                    time = Math.min(time, map[next[0] - 1][next[1]]);
                }
                if (next[0] < N - 1 && map[next[0] + 1][next[1]] == g) {
                    queue.add(new int[]{next[0] + 1, next[1]});
                    map[next[0] + 1][next[1]] = map[next[0]][next[1]] - 1;
                    time = Math.min(time, map[next[0] + 1][next[1]]);
                }
                if (next[1] > 0 && map[next[0]][next[1] - 1] == g) {
                    queue.add(new int[]{next[0], next[1] - 1});
                    map[next[0]][next[1] - 1] = map[next[0]][next[1]] - 1;
                    time = Math.min(time, map[next[0]][next[1] - 1]);
                }
                if (next[1] < N - 1 && map[next[0]][next[1] + 1] == g) {
                    queue.add(new int[]{next[0], next[1] + 1});
                    map[next[0]][next[1] + 1] = map[next[0]][next[1]] - 1;
                    time = Math.min(time, map[next[0]][next[1] + 1]);
                }

            }
            time = Math.abs(time);
            System.out.println("#" + t + " " + time);
        }

        //TO-Do
        // Solution
        long endTime = System.currentTimeMillis();
        //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


}