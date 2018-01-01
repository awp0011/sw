package sw.pro.SDS_PRO_6_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class source {

    /**
     * http://koitp.org/problem/SDS_PRO_6_2/read/
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String magic = br.readLine().trim();
        String bridge1 = br.readLine().trim();
        String bridge2 = br.readLine().trim();

        int[][][] dp = new int[magic.length() + 1][bridge1.length() + 1][2 + 1];

        for (int i = 1; i <= magic.length(); i++) {
            for (int j = 1; j <= bridge1.length(); j++) {
                for (int k = 1; k <= 2; k++) {
                    if (i == 1) {
                        dp[1][j][k] = dp[1][j - 1][k] + ((((k == 1) ? bridge1.charAt(j - 1) : bridge2.charAt(j - 1)) == magic.charAt(i - 1)) ? 1 : 0);
                    } else {
                        dp[i][j][k] = dp[i][j - 1][k] + ((((k == 1) ? bridge1.charAt(j - 1) : bridge2.charAt(j - 1)) == magic.charAt(i - 1)) ? dp[i - 1][j - 1][3 - k] : 0);
                    }
                }
            }
        }

        System.out.println(dp[magic.length()][bridge1.length()][1] + dp[magic.length()][bridge1.length()][2]);

    }

}
