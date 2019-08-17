package sw.luogu;

import java.util.Scanner;

public class P1464 {
    private static long a = 0, b = 0, c = 0;
    private static long[][][] data = new long[25][25][25];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        do {

            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
        }
        while ((a == -1) && (b == -1) && (c == -1));
    }

    private static long w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) return 1;
        if (a > 20 || b > 20 || c > 20) return w(20, 20, 20);
        if (data[a][b][c] > 0) return data[a][b][c];
        if (a < b && b < c) {
            data[a][b][c - 1] = w(a, b, c - 1);
            data[a][b - 1][c - 1] = w(a, b - 1, c - 1);
            data[a][b - 1][c] = w(a, b - 1, c);
            return data[a][b][c - 1] + data[a][b - 1][c - 1] + data[a][b - 1][c];
        }
        return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
    }
}
