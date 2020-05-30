package sw.luogu.stage4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5718 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int min = 1000;
        for (int i = 0; i < n; i++) {
            in.nextToken();

            min = Math.min(min, (int) in.nval);
        }
        System.out.println(min);
    }
}
