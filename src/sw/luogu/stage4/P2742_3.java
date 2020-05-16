package sw.luogu.stage4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P2742_3 {
    private static Point[] p, S;
    private static int n, top;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        S = new Point[n + 3];
        p = new Point[n + 3];
        int min = 0;
        p[0] = new Point();
        p[0].x = Integer.MAX_VALUE;
        p[0].y = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            p[i] = new Point();
            S[i] = new Point();
            in.nextToken();
            p[i].x = in.nval;
            in.nextToken();
            p[i].y = in.nval;

            if (p[i].y < p[min].y) min = i;
            else if (p[i].y == p[min].y && p[i].x < p[min].x) min = i;
        }
        p[0] = p[1];
        p[1] = p[min];
        p[min] = p[0];

        Arrays.sort(p, 1, n + 1, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int cp = ccw(p[1], o1, o2);
                if (cp == 0) return dist(p[1], o1) >= dist(p[1], o2) ? 1 : -1;
                return cp;
            }
        });
        //提前在栈中放入节点
        S[0] = p[n];
        S[1] = p[1];
        //S[2] = p[2];
        top = 1;

        //枚举其他节点
        for (int i = 2; i <= n; i++) {
            while (top > 1 && ccw(S[top - 1], S[top], p[i]) >= 0) top--;//如果当前栈顶不是凸包上的节点则弹出
            S[++top] = p[i];//加入凸包的栈中
        }
        //S[++top] = p[1];
        //for (int i = 0; i <= top; ++i) System.out.println(String.format("(%f,%f)\n", S[i].x, S[i].y));
        //System.out.println();
        System.out.println(String.format("%.2f", calculate()));
    }

    private static double calculate() {
        double length = 0;
        for (int i = 0; i < top ; i++) {
            length += Math.sqrt(dist(S[i], S[i + 1]));
        }
        return length;
    }

    private static double dist(Point p1, Point p2) {
        return (Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
    }

    private static int ccw(Point a, Point b, Point c)//计算叉积
    {
        double cross_product = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (cross_product == 0) return 0;//on same line
        else if (cross_product > 0) return -1;//counter clock wise
        else return 1;//clock wise
    }

    private static class Point {
        double x, y;
    }

}