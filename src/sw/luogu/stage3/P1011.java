package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1011 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int a = (int) in.nval;
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int x = (int) in.nval;

        if (x <= 3) {
            if (x == 1 || x == 2) System.out.println(a);
            if (x == 3) System.out.println(2 * a);
        } else {
            //从第4项开始，a的系数为前两数a的系数之和减一，而p则相反，最后要加一。
            int[] A = new int[n + 5];//a的系数
            A[2] = 1;
            A[3] = 2;
            int[] P = new int[n + 5];//p的系数
            for (int i = 4; i <= n; i++) {
                A[i] = A[i - 1] + A[i - 2] - 1;
                P[i] = P[i - 1] + P[i - 2] + 1;
            }
            //第n项 A[n]*a+P[n]*p=m
            int p = (m - A[n-1] * a) / P[n-1];
            System.out.println(A[x] * a + P[x] * p);
        }
    }
}
