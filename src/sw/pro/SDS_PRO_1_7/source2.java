package sw.pro.SDS_PRO_1_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class source2 {
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
        area[0][0].isInQueue = true;
        queue.add(area[0][0]);

        walkToNN();
        System.out.println(area[End][End].minDiff);
    }

    private static void walkToNN() {
        boolean continued = true;
        while (!queue.isEmpty() && continued) {
            Mountain current = queue.poll();
            if(current.isInQueue) {
                //System.out.println("queue -->"+current.X + "," + current.Y);
                continued = walkToNext(current);
                current.isInQueue = false;
            }
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
        if (from.walkToMe(to)) {
            //System.out.println(to.X + "," + to.Y+"--> queue");
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

        boolean walkToMe(final Mountain to) {
            if (to.isVisited) {
                int diff = to.height - minHeight;
                if (diff < to.minDiff) {
                    to.minDiff = diff;
                    to.minHeight = minHeight;
                    return true;
                }
            } else {
                to.maxHeight = Math.max(maxHeight, to.maxHeight);
                to.minHeight = Math.min(minHeight, to.minHeight);
                to.minDiff = to.maxHeight - to.minHeight;
                to.isVisited = true;
                return true;
            }
            return false;
        }

    }

}