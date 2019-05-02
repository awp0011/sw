package sw.contest.vjudge.UVA658;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final Path[] paths = new Path[100];
    private static final PriorityQueue<Status> queue = new PriorityQueue<>(Comparator.comparingLong(Status::getTime));
    private static final HashSet<Integer> isVisited = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            Status s = new Status((int) Math.pow(2, n) - 1, 0);
            queue.add(s);
            isVisited.add(s.value);
            for (int i = 0; i < m; i++) {
                if (paths[i] == null) paths[i] = new Path(new StringTokenizer(br.readLine()));
                else paths[i].init(new StringTokenizer(br.readLine()));
            }
            long ans = Long.MAX_VALUE;
            while (!queue.isEmpty()) {
                Status as = queue.poll();
                for (int i = 0; i < m; i++) {
                    if (paths[i].isMatch(as.value)) {
                        int next = paths[i].doPath(as.value);
                        if (next == 0) ans = Math.min(ans, as.timeSum + paths[i].time);
                        else {
                            if (isVisited.contains(next)) continue;
                            isVisited.add(next);
                            queue.add(new Status(next, as.timeSum + paths[i].time));
                        }
                    }
                }
            }

            System.out.printf("Product %d\n", T++);
            if (ans == Integer.MAX_VALUE) {
                System.out.println("Bugs cannot be fixed.\n\n");
            } else {
                System.out.printf("Fastest sequence takes %d seconds.\n\n", ans);

            }
            isVisited.clear();
        }

    }

    private static class Status {
        int value;
        long timeSum;

        Status(int v, long t) {
            value = v;
            timeSum = t;
        }

        long getTime() {
            return timeSum;
        }
    }

    private static class Path {
        final char PLUS = 43;//+加号
        final char MINUS = 45;//- 减号
        int time;
        int p1, p2;
        int r1, r2;

        Path(StringTokenizer st) {
            init(st);
        }

        void init(StringTokenizer st) {
            time = Integer.parseInt(st.nextToken());
            String pattern1 = st.nextToken();
            String pattern2 = st.nextToken();
            p1 = p2 = r1 = r2 = 0;
            for (int i = 0; i < pattern1.length(); i++) {
                if (PLUS == pattern1.charAt(i)) {
                    p1 = (p1 << 1) + 1;
                    p2 = (p2 << 1) + 1;
                } else if (MINUS == pattern1.charAt(i)) {
                    p1 = (p1 << 1);
                    p2 = (p2 << 1);
                } else {
                    p1 = (p1 << 1);
                    p2 = (p2 << 1) + 1;
                }
                if (PLUS == pattern2.charAt(i)) {
                    r1 = (r1 << 1) + 1;
                    r2 = (r2 << 1) + 1;
                } else if (MINUS == pattern2.charAt(i)) {
                    r1 = (r1 << 1);
                    r2 = (r2 << 1);
                } else {
                    r1 = (r1 << 1);
                    r2 = (r2 << 1) + 1;
                }
            }
        }

        boolean isMatch(int t) {
            return (t == (t | p1)) && (t == (t & p2));
        }

        int doPath(int t) {
            return ((t | r1) & r2);
        }
    }
}
