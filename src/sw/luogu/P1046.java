package sw.luogu;

import java.util.Scanner;

public class P1046 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] H = new int[10];
        for (int i = 0; i < 10; i++) {
            H[i] = sc.nextInt();
        }
        int tall = sc.nextInt() + 30;

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if(tall >= H[i]) cnt ++;
        }
        System.out.println(cnt);
    }
}
