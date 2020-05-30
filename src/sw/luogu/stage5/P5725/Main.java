package sw.luogu.stage5.P5725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int k = 1;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (k < 10) ans.append(0);
                ans.append(k++);
            }
            ans.append('\n');
        }
        ans.append('\n');
        k = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > 0; j--) {
                if (j - i >= 1) {
                    ans.append("  ");
                } else {
                    if (k < 10) ans.append(0);
                    ans.append(k++);
                }
            }
            ans.append('\n');
        }
        System.out.println(ans.toString());
    }
}
