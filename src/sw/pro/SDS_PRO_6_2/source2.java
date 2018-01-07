package sw.pro.SDS_PRO_6_2;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String magic = br.readLine();
        String angle = br.readLine();
        String evils = br.readLine();
        int[][][] dp = new int[magic.length() + 1][angle.length() + 1][3];

        for (int i = 1; i <= magic.length(); i++) {
            for (int j = 1; j <= angle.length(); j++) {
                for (int k = 1; k < 3; k++) {
                    dp[i][j][k] = dp[i][j - 1][k] + (((k == 1) ? angle.charAt(j - 1) : evils.charAt(j - 1)) == magic.charAt(i - 1) ? ((i == 1) ? 1 : dp[i - 1][j - 1][3 - k]) : 0);
                }
            }
        }
        System.out.println(dp[magic.length()][angle.length()][1] + dp[magic.length()][angle.length()][2]);
    }

}
