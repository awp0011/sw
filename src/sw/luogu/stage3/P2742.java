package sw.luogu.stage3;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class P2742 {
    private static double[][] nodes;
    private static int n;
    private static final ArrayList<double[]> up = new ArrayList<>();
    private static final ArrayList<double[]> down = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        nodes = new double[n + 3][2];
        nodes[0][0] = Double.MAX_VALUE;
        nodes[0][1] = Double.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            nodes[i][0] = in.nval;
            in.nextToken();
            nodes[i][1] = in.nval;
        }
        Arrays.sort(nodes, 1, n + 1, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] < o2[0]) {
                return -1;
            } else {
                return o1[1] > o2[1] ? 1 : -1;
            }
        });
        ConvexHull();
        System.out.println(String.format("%.2f", calculate()));
    }

    private static double calculate() {
        double length = 0;
        for (int i = 0; i < up.size() - 1; ++i) {
            length += Math.sqrt(Math.pow(up.get(i)[0] - up.get(i + 1)[0], 2) + Math.pow(up.get(i)[1] - up.get(i + 1)[1], 2));
        }
        for (int i = 0; i < down.size() - 1; ++i) {
            //length += Math.sqrt(Math.pow(down.get(i)[0] - down.get(i + 1)[0], 2) + Math.pow(down.get(i)[1] - down.get(i + 1)[1], 2));
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
        up.add(nodes[n-1]);
        for (int i = n-2; i >=1;i--) {
            up.add(nodes[i]);
            while (CCW(up.get(up.size() - 3), up.get(up.size() - 2), up.get(up.size() - 1))) {
                up.remove(up.size() - 2);
            }

        }
    }
}
