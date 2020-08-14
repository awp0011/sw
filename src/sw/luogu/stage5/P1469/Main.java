package sw.luogu.stage5.P1469;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int ans = 0;
        for (int i = 0; i <n ; i++) {
            ans ^= in.nextInt();
        }
        System.out.println(ans);
    }
}
