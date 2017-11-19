package sw.pro.SDS_PRO_1_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class source {
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
        area[0][0].isVisited = true;
        walkToNext(area[0][0]);
        walkToNN();
        System.out.println(area[End][End].minDiff);
        System.out.println(area[End][End].maxHeight+"-"+area[End][End].minHeight);
    }

    private static void walkToNN() {
        boolean continued = true;
        while (!queue.isEmpty()) {
            Mountain current = queue.poll();
            //System.out.println(current.X + "," + current.Y);
            continued = walkToNext(current);
        }

    }

    private static boolean walkToNext(final Mountain from) {
        int nextAxis = from.X + 1;
        if (nextAxis < N) {
            from.walkTo(area[nextAxis][from.Y]);
            if (nextAxis == End && from.Y == End) {
                return false;
            }
        }
        nextAxis = from.Y + 1;
        if (nextAxis < N) {
            from.walkTo(area[from.X][nextAxis]);
            if (nextAxis == End && from.X == End) {
                return false;
            }
        }
        if (from.X > 1) {
            from.walkTo(area[from.X - 1][from.Y]);
        }

        if (from.Y > 1) {
            from.walkTo(area[from.X][from.Y - 1]);
        }
        return true;
    }


    private static class Mountain {
        int X;
        int Y;
        int height;
        int minHeight;
        int maxHeight;
        int minDiff;
        boolean isVisited = false;

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

        void walkTo(final Mountain to) {
            if (!to.isVisited) {
                to.maxHeight = Math.max(maxHeight, to.maxHeight);
                to.minHeight = Math.min(minHeight, to.minHeight);
                to.minDiff = to.maxHeight - to.minHeight;
                to.isVisited = true;
                queue.add(to);
            }
        }

    }

}