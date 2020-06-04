package sw.luogu.stage5.P5736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            in.nextToken();
            if (1 >= (int) in.nval) continue;
            else if (2 == (int) in.nval || isPrime((int) in.nval)) ans.append((int) in.nval).append(' ');
        }
        System.out.println(ans.toString());
    }

    private static boolean isPrime(int i) {
        int end = (int) Math.sqrt(i);
        for (int j = 2; j <= end; j++) {
            if (i % j == 0) return false;
        }
        return true;
    }
}
