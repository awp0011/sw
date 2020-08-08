package sw.luogu.stage5.P1348;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        long a = (long) in.nval;
        in.nextToken();
        long b = (long) in.nval;
        long ans = 0;
        for (long i = a; i <= b; i++) if (i % 2 != 0 || i % 4 == 0) ans++;
        System.out.println(ans);
    }
}
