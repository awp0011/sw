package sw.luogu.stage5.P4956;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = ((int) in.nval)/52;
        int p1 = 7;
        int p2 = 21;

        int x = 101, k = 0;
        while (x > 100) {
            k++;
            if ((n - k * p2) % p1 == 0)
                x = (n - k * p2) / p1;

        }
        System.out.println(x);
        System.out.println(k);
    }
}
