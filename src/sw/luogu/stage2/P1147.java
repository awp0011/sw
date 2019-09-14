package sw.luogu.stage2;

import java.util.Scanner;

public class P1147 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 3;
        for (int L = 1, R = 2; L <= (n >> 1); ) {
            if (sum == n) {
                System.out.println(L + " " + R);
                sum -= L;
                L++;
            } else if (sum < n) {
                R++;
                sum += R;
            }else{
                sum -= L;
                L++;
            }
        }
    }

}
