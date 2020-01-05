package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1720 {
    private static double[] ans = {0.00, 1.00, 1.00, 2.00, 3.00, 5.00, 8.00, 13.00, 21.00,
            34.00, 55.00, 89.00, 144.00, 233.00, 377.00, 610.00, 987.00,
            1597.00, 2584.00, 4181.00, 6765.00, 10946.00, 17711.00, 28657.00, 46368.00,
            75025.00, 121393.00, 196418.00, 317811.00, 514229.00, 832040.00, 1346269.00, 2178309.00,
            3524578.00, 5702887.00, 9227465.00, 14930352.00, 24157817.00, 39088169.00, 63245986.00, 102334155.00,
            165580141.00, 267914296.00, 433494437.00, 701408733.00, 1134903170.00, 1836311903.00, 2971215073.00, 4807526976.00, 0
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(String.format("%.2f",ans[Integer.parseInt(br.readLine())]));
    }

}
