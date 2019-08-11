package sw.luogu;

import java.util.Scanner;

public class P1047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        boolean[] line = new boolean[len + 1];
        int end = sc.nextInt();
        for (int i = 0; i < end; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            for (int j = a; j <= b; j++) {
                line[j] = true;
            }
        }
        int cnt = line.length;
        for (int i = 0; i <= len; i++) {
            if (line[i]) cnt--;
        }
        System.out.println(cnt);
    }
}
