package sw.luogu.stage1;

import java.util.Scanner;

public class P1014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = 0, p = 0;
        int m = 1, index = 1;

        do {
            n -= m;
            m += 1;
            index++;
        } while (n > m);

        if (index % 2 == 0) {
            c = 1;
            p = index;
            for (int i = n; i > 1; i--) {
                c++;
                p--;
            }
        } else {
            c = index;
            p = 1;
            for (int i = n; i > 1; i--) {
                c--;
                p++;
            }
        }
        System.out.println(c + "/" + p);
    }
}
