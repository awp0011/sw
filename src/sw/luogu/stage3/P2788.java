package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2788 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int sum = 0;
        int a = 0, b = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '+') {
                sum += a * b;
                a = 0;
                b = 1;
            } else if (s.charAt(i) == '-') {
                sum += a * b;
                b = -1;
                a = 0;
            } else {
                a = a * 10 + (s.charAt(i) - '0');
            }
        }
        System.out.println(sum + (a * b));
    }
}
