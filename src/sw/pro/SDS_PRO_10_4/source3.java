package sw.pro.SDS_PRO_10_4;
//Kruskal算法

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class source3 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point[] V = new Point[N+1];
        for (int i = 0; i <= N; i++) {
            V[i] = new Point(i);
        }
        int M = Integer.parseInt(br.readLine());
        PriorityQueue<Line> queue = new PriorityQueue<>(Comparator.comparingInt(Line::getCost));
        for (int i = 0; i < M; i++) {
            int s, e, c;
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            queue.add(new Line(s, e, c));
        }
        br.close();
        long total = 0L;

        while (V[1].parent.chilren_cnt != N) {
            Line min = queue.poll();
            if (!find(V[min.Start]).equals(find(V[min.End]))) {
                //System.out.println("min--> "+min.toString());
                union(V[min.Start], V[min.End]);
                total += min.getCost();
            }

        }
        System.out.println(total);
    }

    private static void union(final Point c1, final Point c2) {
        if (c1.parent.equals(c2.parent)) return;
        if (c1.parent.chilren_cnt > c2.parent.chilren_cnt) {
            c1.parent.chilren_cnt += c2.parent.chilren_cnt;
            c2.parent.parent = c1.parent;
        } else {
            c2.parent.chilren_cnt += c1.parent.chilren_cnt;
            c1.parent.parent = c2.parent;
        }
    }

    private static Point find(final Point c) {
        if (c.equals(c.parent)) return c;
        c.parent = find(c.parent);
        return c.parent;
    }

    private static class Line {
        int Start, End, Cost;

        Line(final int s, final int e, final int c) {
            Start = s;
            End = e;
            Cost = c;
        }

        int getCost() {
            return Cost;
        }

        public String toString() {
            return "S:" + Start + " E:" + End + " C:" + Cost;
        }
    }

    private static class Point {
        int index;
        int chilren_cnt;
        Point parent;

        Point(final int i) {
            index = i;
            chilren_cnt = 1;
            parent = this;
        }

        boolean equals(Point other) {
            return other != null && index == other.index;
        }
    }
}