package sw.pro.convexhull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class source {
    private static Point[] nodes;
    private static int n;
    private static final ArrayList<Point> up = new ArrayList<>();
    private static final HashSet<Point> ret = new HashSet<>();

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        nodes = new Point[n + 3];
        for (int i = 1; i <= n; i++) {
            if(nodes[i]==null)nodes[i] = new Point(i);
            in.nextToken();
            nodes[i].x = (int)in.nval;
            in.nextToken();
            nodes[i].y = (int)in.nval;
        }
        Arrays.sort(nodes, 1, n + 1, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.x == o2.x?o1.y - o2.y:o1.x - o2.x;
            }
        });
        ConvexHull();
        System.out.println(ret.size());
    }



    private static boolean CCW(Point a, Point b, Point c) {
        return ((b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x)) >= 0;
    }

    private static void ConvexHull() {
        for (int i = 1; i <= n; ++i) {
            up.add(nodes[i]);
            while (up.size() > 2 && CCW(up.get(up.size() - 3), up.get(up.size() - 2), up.get(up.size() - 1))) {
                up.remove(up.size() - 2);
            }

        }
        up.add(nodes[n-1]);
        for (int i = n-2; i >=1;i--) {
            up.add(nodes[i]);
            while (CCW(up.get(up.size() - 3), up.get(up.size() - 2), up.get(up.size() - 1))) {
                up.remove(up.size() - 2);
            }

        }
        ret.addAll(up);
    }
    private static class Point{
        final int idx;
        int x,y;
        Point(int i){idx=i;}
        //重写equals()方法:判断姓名和年龄两者是否都相同;
        @Override
        public boolean equals(Object obj) {
            Point p = (Point) obj;
            return p.idx == this.idx;
        }
        //重写hashcode()方法:
        @Override
        public int hashCode() {
            return idx;
        }
    }
}
