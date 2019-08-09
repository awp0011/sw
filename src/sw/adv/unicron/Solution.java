package sw.adv.unicron;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    private static final int[][] offsets = new int[][]{
            {-2, 1}, {-2, 1}, {-1, 2}, {-1, -2},
            {1, 2}, {1, -2}, {2, 1,}, {2, -1}
    };
    private static int N;
    private static boolean over;
    private static int ex;
    private static int ey;
    private static final int[][] map = new int[1000][1000];

    private static final PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> {
        if (e1[1] == e2[1]) {
            return e1[2] - e2[2];
        } else {
            return e1[1] - e2[1];
        }
    });

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            ex = sc.nextInt();
            ey = sc.nextInt();
            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    map[sx][sy] = Integer.MAX_VALUE >> 1;
                }
            }
            map[sx][sy] = 0;
            over = false;
            queue.add(new int[]{sx * N + sy, map[sx][sy], distance(sx, sy)});
            play();
            System.out.println("#" + t + " " + map[ex][ey]);

        }
    }

    private static int distance(int x1, int y1) {
        return Math.abs(x1 - ex) + Math.abs(y1 - ey);
    }

    private static boolean onBoard(int x, int y) {
        return (x > 0) && (x <= N) && (y > 0) && (y <= N);
    }

    private static void play() {
        while (!queue.isEmpty() && !over) {
            int[] start = queue.poll();
            move(start[0], 0);
        }
    }

    private static void move(int pos, int cnt) {
        if (cnt < 3 && !over) {
            int x = pos / N;
            int y = pos % N;
            for (int[] next : offsets) {
                int nextX = x + next[0];
                int nextY = y + next[1];
                if (onBoard(nextX, nextY)) {
                    if (map[x][y] > map[nextX][nextY] + 1) {
                        map[x][y] = map[nextX][nextY] + 1;
                        if (nextX == ex && nextY == ey) over = true;
                        else queue.offer(new int[]{nextX * N + nextY, map[x][y], distance(nextX, nextY)});
                    }
                    move(nextX * N + nextY, cnt + 1);
                }
            }
        }
    }
}
