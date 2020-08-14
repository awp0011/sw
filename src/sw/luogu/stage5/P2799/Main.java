package sw.luogu.stage5.P2799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    static String n;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = in.sval;
        dfs(n.length());
    }

    static void dfs(int len) {
        if (len % 2 == 1) {
            System.out.println(len);
            System.exit(0);
        }
        int right = len >> 1;
        int left = right - 1;
        while (left >= 0) {
            if (n.charAt(left) != n.charAt(right)) {
                System.out.println(len);
                System.exit(0);
            }
            left--;
            right++;
        }
        dfs(len >> 1);
    }
}
