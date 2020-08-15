package sw.luogu.stage5.P1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int C = (int) in.nval;
        int[] t = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            t[i] = (int) in.nval;
        }
        Arrays.sort(t,1,n+1);
        int[] d1 = new int[n + 1];
        int[] d2 = new int[n + 1];

        int idx = 1;
        for (int i = 1; i <= n; i++) {
            if (t[i - 1] == t[i]) d2[idx - 1]++;
            else {
                d2[idx]++;
                d1[idx++] = t[i];
            }
        }
        int ans = 0;
        for (int i = 1; i < idx; i++) {
            int key = d1[i] + C;
            int pos = Arrays.binarySearch(d1, i + 1, idx, key);
            if (pos > 0) {
                ans += d2[i] * d2[pos];
            }
        }
        System.out.println(ans);
    }
}
