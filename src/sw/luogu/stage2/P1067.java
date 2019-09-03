package sw.luogu.stage2;

import java.util.Scanner;

public class P1067 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] parms = new int[n + 1];
        for (int i = 0; i <= n; i++) parms[i] = sc.nextInt();
        for (int i = 0; i < parms.length; i++) {
            if (parms[i] < 0) System.out.print('-');
            else if (parms[i] > 0 && i != 0) System.out.print("+");
            int parm = Math.abs(parms[i]);
            if (parm > 1 || (n == 0 && parm > 0)) System.out.print(parm);
            if (parm > 0) {
                if (n > 0) System.out.print("x");
                if (n > 1) System.out.print("^" + n);
            }
            n--;
        }
    }
}
