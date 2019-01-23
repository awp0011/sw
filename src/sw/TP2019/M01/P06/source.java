package sw.TP2019.M01.P06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class source {
    private static int[] X;
    private static int[] Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        X = new int[N + 1];
        Y = new int[N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = parseInt(st.nextToken());
            Y[i] = parseInt(st.nextToken());
        }
        br.close();
        int Ex = 1, Ey = 2;
        double Emin = Double.MAX_VALUE;
        int Mx = 1, My = 2, Mmin = Integer.MAX_VALUE;
        int Cx = 1, Cy = 2, Cmin = Integer.MAX_VALUE;
        int temp1;
        double temp2;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                temp2 = E(i, j);
                if (temp2 < Emin) {
                    Ex = i;
                    Ey = j;
                    Emin = temp2;
                }
                temp1 = M(i, j);
                if (temp1 < Mmin) {
                    Mx = i;
                    My = j;
                    Mmin = temp1;
                }
                temp1 = C(i, j);
                if (temp1 < Cmin) {
                    Cx = i;
                    Cy = j;
                    Cmin = temp1;
                }
            }
        }
        System.out.println(Ex + " " + Ey);
        System.out.println(Mx + " " + My);
        System.out.println(Cx + " " + Cy);
    }

    private static double E(int p1, int p2) {
        return pow(abs(X[p1] - X[p2]), 2) + pow(abs(Y[p1] - Y[p2]), 2);
    }

    private static int M(int p1, int p2) {
        return abs(X[p1] - X[p2]) + abs(Y[p1] - Y[p2]);
    }

    private static int C(int p1, int p2) {
        return max(abs(X[p1] - X[p2]), abs(Y[p1] - Y[p2]));
    }
}
