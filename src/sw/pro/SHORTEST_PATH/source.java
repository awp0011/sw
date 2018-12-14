package sw.pro.SHORTEST_PATH;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.fill;
import static java.util.Arrays.sort;

public class source {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());


        int[][] map = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map[i][0] = parseInt(st.nextToken());
            map[i][1] = parseInt(st.nextToken());
            map[i][2] = parseInt(st.nextToken());
        }

        sort(map, (a, b) -> a[0] != b[0] ?
                a[0] - b[0] : a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]);
        PriorityQueue<Road> queue = new PriorityQueue<>(Comparator.comparingInt(Road::getLength));
        int x = 0, y = 0;
        for (int i = 0; i < M; i++) {
            if (x == map[i][0] && y == map[i][1]) continue;
            x = map[i][0];
            y = map[i][1];
            queue.add(new Road(x, y, map[i][2]));
        }
        long[] length = new long[N + 1];
        fill(length, Long.MAX_VALUE);
        length[1] = 0;
        while (queue.peek() != null && !queue.isEmpty()) {
            Road r = queue.poll();
            length[r.Y] = Math.min(length[r.Y], length[r.X] + r.L);
        }
        System.out.println(length[N]);
    }

    private static class Road {
        int X;
        int Y;
        int L;

        Road(int a, int b, int c) {
            X = a;
            Y = b;
            L = c;
        }

        int getLength() {
            return L;
        }
    }

}
