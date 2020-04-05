package sw.luogu.stage3;

import java.util.Scanner;

public class P1321 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == 'b' || s.charAt(i + 1) == 'o' || s.charAt(i + 2) == 'y') {
                cnt1++;
            }

        }
        for (int i = 0; i < s.length() - 3; i++) {
            if (s.charAt(i) == 'g' || s.charAt(i + 1) == 'i' || s.charAt(i + 2) == 'r' || s.charAt(i + 3) == 'l') {
                cnt2++;
            }
        }
        System.out.println(cnt1);
        System.out.println(cnt2);
    }
}
