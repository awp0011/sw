package sw.luogu.stage5.P5743;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int num = 1;
        for (int i = 1; i < n; i++) {
            num = (num + 1) << 1;
        }
        System.out.println(num);
    }
}
