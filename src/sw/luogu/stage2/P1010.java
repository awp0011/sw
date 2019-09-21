package sw.luogu.stage2;

import java.util.Scanner;

public class P1010 {
    private static final int[] base = new int[]{
            1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(divide(n));
    }

    private static String divide(int n) {
        int i = 15;
        String ret = "";
        while (i >= 0) {
            if ((n & base[i]) == base[i]) {
                if (i == 0) ret += "+2(0)";
                else if (i == 1) ret += "+2";
                else if (i == 2) ret += "+2(2)";
                else {
                    ret += "+2(" + divide(i) + ")";
                }
            }
            i--;
        }
        return ret.substring(1);
    }
}
