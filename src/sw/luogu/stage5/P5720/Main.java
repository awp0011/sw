package sw.luogu.stage5.P5720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int cnt = 1;
        while (n != 1) {
            n >>= 1;
            cnt++;
        }
        System.out.println(cnt);
    }
}
