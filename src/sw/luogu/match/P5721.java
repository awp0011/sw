package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5721 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        StringBuilder ans = new StringBuilder();
        int index = 1,col=n;
        for (int j = 0; j < n; j++) {
            for (int i = col; i >= 1; i--) {
                if (index < 10) ans.append(0);
                ans.append(index++);
            }
            col--;
            ans.append('\n');
        }
        System.out.println(ans.toString());
    }
}
