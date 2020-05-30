package sw.luogu.stage5.P2669;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int tot = 0;
        int i = 0, j = 1, k = 1;
        while (i < n) {
            for (j = k; j > 0; j--) {
                tot += k;
                i++;
                if (i >= n) break;
            }
            k++;
        }
        System.out.println(tot);
    }
}
