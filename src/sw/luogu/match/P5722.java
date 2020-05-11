package sw.luogu.match;

import java.util.Scanner;

public class P5722 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int c = 0;
        for (int i = 1; i <= a; i++) {
            c += i;
        }
        System.out.println(c);
    }
}
