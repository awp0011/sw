package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1991 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int P = (int) in.nval;
        in.nextToken();
        int S = (int) in.nval;
        int[] p = new int[S + 1];
        for (int i = 1; i <= S; i++) p[i] = i;
        int[][] V = new int[S + 1][2];
        double[][] E = new double[S * (S - 1) >> 1][3];
        int index = 0;
        for (int i = 1; i <= S; i++) {
            in.nextToken();
            V[i][0] = (int) in.nval;
            in.nextToken();
            V[i][1] = (int) in.nval;

            for (int j = i - 1; j >= 1; j--) {
                E[index][0] = i;
                E[index][1] = j;
                E[index][2] = Math.pow(Math.abs(V[i][0] - V[j][0]), 2)
                        + Math.pow(Math.abs(V[i][1] - V[j][1]), 2);
                index++;
            }
        }
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Arrays.sort(E, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return o1[2] == o2[2] ? 0 : o1[2] > o2[2] ? 1 : -1;
            }
        });
        int i = 0, cnt = 0;
        for (; i < index && cnt < S - P; i++) {
            if (union((int) E[i][0], (int) E[i][1], p)) cnt++;
        }
        System.out.printf("%.2f", Math.sqrt(E[i - 1][2]));
    }

    private static int find(int c, int[] p) {
        if (p[c] == c) return c;
        return p[c] = find(p[c], p);
    }

    private static boolean union(int c1, int c2, int[] p) {
        int p1 = find(c1, p);
        int p2 = find(c2, p);
        if (p1 == p2) return false;
        if (p1 < p2) p[p2] = p1;
        else p[p1] = p2;
        return true;
    }

}
