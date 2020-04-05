package sw.luogu.stage3;

import java.util.Scanner;

public class P1876 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        StringBuilder ans = new StringBuilder();
        for (long i = 1; i * i <= n; i++) ans.append(i * i).append(' ');
        System.out.println(ans.toString());
    }
}
