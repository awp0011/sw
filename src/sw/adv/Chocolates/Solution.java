package sw.adv.Chocolates;

import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Solution {
    private static final int[] offset_0 = new int[]{-2, -1, 0, 1, 2};
    private static final int[] steps_0 = new int[]{0, 0, 0, 0, 0};
    private static final int[] offset_1 = new int[]{-3, -2, -1, 0, 1, 2, 3};
    private static final int[] steps_1 = new int[]{0, 1, 1, 1, 1, 1, 0};

    private static final int[][] map = new int[55][55];
    private static final boolean[][] isVisited = new boolean[55][55];
    private static final ArrayDeque<int[]> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {

            int N = sc.nextInt();
            for (int i = 1; i < N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] = sc.nextInt();
                    isVisited[i][j] = false;
                }
            }
            sc.nextInt();
            String lastLine = sc.nextLine();
            for (int i = 1; i <= N; i++) {
                if (lastLine.charAt(i) == 'E') {
                    queue.offer(new int[]{N, i, 1});
                    break;
                }
            }
            int ans = 0;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int[] next;
                if (current[2] == 1) {
                    for (int i = 0; i < offset_1.length; i++) {
                         next = goNext(current, offset_1[i], steps_1[1]);
                        if(!isVisited[next[0]][next[1]]) {
                            isVisited[next[0]][next[1]] = true;
                            //todo
                        }
                    }
                } else {
                    for (int i = 0; i < offset_0.length; i++) {
                         next = goNext(current, offset_0[i], steps_0[1]);
                    }
                }
            }

            System.out.println("#" + t + " " + ans);
            queue.clear();

        }

    }

    private static int[] goNext(int[] current, int offset, int step) {
        return new int[]{current[0] - 1, current[1] + offset, step};
    }

}
