package sw.pro.SDS_PRO_1_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class source {
    private static int N;
    private static PriorityQueue<Mountain> queue = new PriorityQueue<>(Comparator.comparing(Mountain::getMinDiff));
    private static Mountain[][] area;
    private static int End;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        End = N - 1;
        area = new Mountain[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = new Mountain(i, j, Integer.parseInt(st.nextToken()));
            }
        }
        walkToNext(area[0][0]);
        area[0][0].isInQueue = true;
        walkToNN();
        System.out.println(area[End][End].minDiff);
    }

    private static void walkToNN() {
        boolean continued = true;
        while (!queue.isEmpty() && continued) {
            Mountain current = queue.poll();
            continued = walkToNext(current);
            current.isInQueue = false;
        }

    }

    private static boolean walkToNext(final Mountain from) {
        int nextAxis = from.X + 1;
        if (nextAxis < N) {
            walk(from, area[nextAxis][from.Y]);
            if (nextAxis == End && from.Y == End) {
                return false;
            }
        }
        nextAxis = from.Y + 1;
        if (nextAxis < N) {
            walk(from, area[from.X][nextAxis]);
            if (nextAxis == End && from.X == End) {
                return false;
            }
        }
        if (from.X > 1) {
            walk(from, area[from.X - 1][from.Y]);
        }

        if (from.Y > 1) {
            walk(from, area[from.X][from.Y - 1]);
        }
        return true;
    }

    private static void walk(final Mountain from, final Mountain to) {
        if (from.walkToMe(to) && !to.isInQueue) {
            queue.add(to);
            to.isInQueue = true;
        }
    }

    private static class Mountain {
        int X;
        int Y;
        int height;
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        boolean isInQueue = false;

        Mountain(final int x, final int y, final int h) {
            X = x;
            Y = y;
            height = h;
            minHeight = h;
            maxHeight = h;
        }

        int getMinDiff() {
            return minDiff;
        }

        boolean walkToMe(final Mountain to) {
            to.maxHeight = Math.max(maxHeight, to.maxHeight);
            to.minHeight = Math.min(minHeight, to.minHeight);
            int diff = to.maxHeight - to.minHeight;
            if (to.minDiff > diff) {
                to.minDiff = diff;
                return true;
            }

            return false;
        }

    }

}
