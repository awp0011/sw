package sw.contest.vjudge.CodeForces1108.A;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int T = sc.nextInt();
        while (T-- > 0) {
            int l1 = sc.nextInt();
            sc.nextInt();
            int l2 = sc.nextInt();
            sc.nextInt();

            System.out.print(l1);
            System.out.print(' ');
            System.out.println(l1 == l2 ? ++l2 : l2);
        }
    }
}
