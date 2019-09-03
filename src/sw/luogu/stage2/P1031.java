package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1031 {
    private static final int[] cards = new int[103];
    private static int n, avg = 0, ans = 0;

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        n = (int) st.nval;
        for (int i = 0; i < n; i++) {
            st.nextToken();
            cards[i] = (int) st.nval;
            avg += cards[i];
        }
        avg /= n;
        for (int i = 0; i < n; i++) {
            if (cards[i] - avg != 0) {
                cards[i + 1] += cards[i] - avg;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
