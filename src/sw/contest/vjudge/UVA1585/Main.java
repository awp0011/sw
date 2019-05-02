package sw.contest.vjudge.UVA1585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] src = new int[83];
        while (T-- > 0) {
            String result = br.readLine();
            int ans = 0;
            Arrays.fill(src, 0);
            src[0] = ans = 'O' == result.charAt(0) ? 1 : 0;
            for (int i = 1; i < result.length(); i++) {
                if (result.charAt(i) == 'O') src[i] = src[i - 1] + 1;
                ans += src[i];
            }
            System.out.println(ans);
        }

    }
}
