package sw.TP2019.M06.P03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class source {
    private static final int MAX = 103;
    private static final int[][][] MAP = new int[MAX][MAX][2];
    private static final int[][] OFFSETS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final Map<Integer, ArrayDeque<Integer>> MOUNTS = new HashMap<>();
    private static int N, maxH, minH;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        maxH = 0;
        minH = 200;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int h = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, h);
                minH = Math.min(minH, h);
                MOUNTS.computeIfAbsent(h, v -> new ArrayDeque<>()).add(i * MAX + j);
            }
        }
        int low = 0;
        int top = maxH - minH;
        while (low < top) {
            int middle = (low + top) >> 1;
            if (test(middle)) {
                top = middle;
            } else {
                low = middle + 1;
            }
        }
        System.out.println(low);
    }


    private static boolean test(int aHeight) {
        int start = minH;
        while (start + aHeight <= maxH) {
            initParent();
            for (int h = start; h <= start + aHeight; h++) {
                if (MOUNTS.containsKey(h)) {
                    for (int pos : MOUNTS.get(h)) {
                        join(pos);
                    }
                }
                if (find(MAX + 1) == find(N * MAX + N)) return true;
            }
            start++;

        }
        return false;
    }

    private static void initParent() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                MAP[i][j][1] = i * MAX + j;
                MAP[i][j][0] = 0;
            }
        }
    }

    private static void join(int pos) {
        int x = pos / MAX;
        int y = pos % MAX;
        MAP[x][y][0] = 1;
        for (int[] os : OFFSETS) {
            int nextX = x + os[0];
            int nextY = y + os[1];
            if (nextX >= 0 && nextX <= N && nextY >= 0 && nextY <= N
                    && MAP[nextX][nextY][0] == 1) union(pos, nextX * MAX + nextY);
        }
    }

    private static void union(int index1, int index2) {
        int p1 = find(index1);
        int p2 = find(index2);
        if (p1 == p2) return;
        if (p1 < p2) MAP[p2 / MAX][p2 % MAX][1] = MAP[p1 / MAX][p1 % MAX][1];
        else MAP[p1 / MAX][p1 % MAX][1] = MAP[p2 / MAX][p2 % MAX][1];

    }

    private static int find(int pos) {
        int x = pos / MAX;
        int y = pos % MAX;

        if (MAP[x][y][1] == pos) return pos;
        return MAP[x][y][1] = find(MAP[x][y][1]);
    }
}
