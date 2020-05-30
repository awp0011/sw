package sw.luogu.stage5.P5723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int L = (int) in.nval;
        int cnt = 0, tot = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 2; tot + i <= L && i < 10000; i++) {
            if (isPrime(i)) {
                tot += i;
                cnt++;
                ans.append(i).append('\n');
            }
        }
        System.out.print(ans.toString());
        System.out.println(cnt);
    }

    private static boolean isPrime(int n) {
        int e = (int) Math.sqrt(n);
        boolean is = true;
        for (int i = 2; is && i <= e; i++) {
            if (n % i == 0) is = false;
        }
        return is;
    }
}
