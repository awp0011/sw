package sw.luogu.stage4;

import java.util.Scanner;

public class P5713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int c1 = cnt * 5;
        int c2 = cnt * 3 + 11;
        System.out.println(c1 < c2 ? "Local" : "Luogu");
    }
}
