package sw.pro.NQUEEN;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {

    static int sum = 0, upperlim = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        upperlim = (upperlim << N) - 1;
        test(0, 0, 0);
        System.out.println(sum);

    }

    static void test(int row, int ld, int rd) {
        if (row != upperlim) {
            int pos = upperlim & ~(row | ld | rd);
            while (pos != 0) {
                int p = pos & -pos;
                pos -= p;
                test(row + p, (ld + p) << 1, (rd + p) >> 1);
            }
        } else {
            sum++;
        }
    }

}
