package sw.TP2019.M01.P01;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {
    static int[][] matrix;
    static int count0 = 0;
    static int count1 = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] splits = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(splits[j]);
            }
        }

        f(0, 0, N);
        System.out.println(count0);
        System.out.println(count1);
    }

    public static void f(int x, int y, int size) {

        int sum = 0;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                sum += matrix[i][j];
            }
        }
        if (sum == size * size) count1++;
        else if (sum == 0) count0++;
        else {
            int half = size / 2;
            f(x, y, half);
            f(x + half, y, half);
            f(x, y + half, half);
            f(x + half, y + half, half);
        }

    }
}
