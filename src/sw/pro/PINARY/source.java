package sw.pro.PINARY;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {
    private static long[][] data = new long[90][90];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) - 1;//左边第一位必定是1,所以减1
        br.close();
        long answer = 0L;
        int end = N >> 1;//1的个数是N/2
        for (int i = 0; i <= end; i++) {
            //i表示1的个数，因为1不能连续，所以01必须以前出现，因而有（i<<1），一个1就要有一个01
            answer += combine(N - i, i);
        }
        System.out.println(answer);
    }

    //C(m,n)表示：m个数取n
    private static long combine(final int m, final int n) {
        if (data[m][n] > 0) return data[m][n];
        if (n == 0 || m == 0) {
            data[m][n] = 1;
        } else if (n == 1) {
            data[m][n] = m;
        } else if (m == n) {
            data[m][n] = 1;
        } else {
            data[m - 1][n - 1] = combine(m - 1, n - 1);
            data[m - 1][n] = combine(m - 1, n);
            data[m][n] = data[m - 1][n - 1] + data[m - 1][n];
        }
        return data[m][n];
    }

}