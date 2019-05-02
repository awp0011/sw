package sw.contest.vjudge.CodeForces1030.A;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        int T = sc.nextInt();
        int ans = 0;
        while (ans == 0 && T-- > 0) {
            ans += sc.nextInt();
        }
        System.out.println(ans > 0 ? "HARD" : "EASY");
    }
}