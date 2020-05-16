package sw.learning;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Andrew {
    private static double[][] nodes;// = new double[100005][2];
    private static int n, k;
    private static final ArrayList<double[]> up = new ArrayList();
    private static final ArrayList<double[]> down = new ArrayList();

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        nodes = new double[n + 3][2];
        nodes[0][0] = Double.MAX_VALUE;
        nodes[0][1] = Double.MAX_VALUE;
        k = 0;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            nodes[i][0] = in.nval;
            in.nextToken();
            nodes[i][1] = in.nval;

            //找到最左下的点
            if (nodes[0][0] > nodes[i][0] || (nodes[0][0] > nodes[i][0] && nodes[0][1] > nodes[i][1])) {
                nodes[0] = nodes[i];
                k = i;
            }
        }
        nodes[k] = nodes[1];
        nodes[1] = nodes[0];
/*        Arrays.sort(nodes, 1, n + 1, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return o1[1] > o2[1] ? 1 : -1;
                }
            }
        });*/
        Arrays.sort(nodes, 2, n + 1, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                double a = Math.atan2((o1[1] - nodes[1][1]), (o1[0] - nodes[1][0]));
                double b = Math.atan2((o2[1] - nodes[1][1]), (o2[0] - nodes[1][0]));
                if (a != b) return a < b ? -1 : 1;
                else return o1[0] < o2[0] ? -1 : 1;
            }

        });
        ConvexHull();
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        pw.printf("%.2f %n", calculate());
        pw.close();
    }

    private static double calculate() {
        double length = 0;
        for (int i = 0; i < up.size() - 1; ++i) {
            length += Math.sqrt(Math.pow(up.get(i)[0] - up.get(i + 1)[0], 2) + Math.pow(up.get(i)[1] - up.get(i + 1)[1], 2));
        }
        for (int i = 0; i < down.size() - 1; ++i) {
            length += Math.sqrt(Math.pow(down.get(i)[0] - down.get(i + 1)[0], 2) + Math.pow(down.get(i)[1] - down.get(i + 1)[1], 2));
        }
        return length;
    }

    private static boolean CCW(double[] a, double[] b, double[] c) {
        return ((b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0])) >= 0;
    }

    private static void ConvexHull() {
        for (int i = 1; i <= n; ++i) {
            up.add(nodes[i]);
            while (up.size() > 2 && CCW(up.get(up.size() - 3), up.get(up.size() - 2), up.get(up.size() - 1))) {
                up.remove(up.size() - 2);
            }
            down.add(nodes[i]);
            while (down.size() > 2 && !CCW(down.get(down.size() - 3), down.get(down.size() - 2), down.get(down.size() - 1))) {
                down.remove(down.size() - 2);
            }
        }
    }
}
