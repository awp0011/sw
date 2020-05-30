package sw.luogu.stage4;

import java.util.Scanner;

public class P5711 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (year % 400 == 0) {
            System.out.println(1);
        } else if (year % 100 == 0) {
            System.out.println(0);
        } else {
            System.out.println(year % 4 == 0 ? 1 : 0);
        }
    }
}
