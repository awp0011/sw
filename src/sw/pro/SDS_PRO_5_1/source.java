package sw.pro.SDS_PRO_5_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class source {
    private static int[] X;
    private static int[] Y;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        X = new int[N + 1];
        Y = new int[N + 1];
        StringTokenizer st;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = Integer.parseInt(st.nextToken());
            Y[i] = Integer.parseInt(st.nextToken());
        }

        int Euclidean1 = 1, Euclidean2 = 2;//欧几里得
        int Manhattan1 = 1, Manhattan2 = 2;//曼哈顿
        int Chebyshev1 = 1, Chebyshev2 = 2;//切比雪夫

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (calculateEuclidean(i, j) < calculateEuclidean(Euclidean1, Euclidean2)) {
                    Euclidean1 = i;
                    Euclidean2 = j;
                }

                if (calculateManhattan(i, j) < calculateManhattan(Manhattan1, Manhattan2)) {
                    Manhattan1 = i;
                    Manhattan2 = j;
                }

                if (calculateChebyshev(i, j) < calculateChebyshev(Chebyshev1, Chebyshev2)) {
                    Chebyshev1 = i;
                    Chebyshev2 = j;
                }
            }
        }
        System.out.println(Euclidean1 + " " + Euclidean2);
        System.out.println(Manhattan1 + " " + Manhattan2);
        System.out.println(Chebyshev1 + " " + Chebyshev2);
        br.close();

    }

    private static double calculateEuclidean(final int p1, final int p2) {
        return Math.pow(X[p1] - X[p2], 2) + Math.pow(Y[p1] - Y[p2], 2);
    }

    private static int calculateManhattan(final int p1, final int p2) {
        return Math.abs(X[p1] - X[p2]) + Math.abs(Y[p1] - Y[p2]);
    }

    private static int calculateChebyshev(final int p1, final int p2) {
        return Math.max(Math.abs(X[p1] - X[p2]), Math.abs(Y[p1] - Y[p2]));
    }
}