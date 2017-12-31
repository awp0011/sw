package sw.pro.SDS_PRO_6_2;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source2 {
    private static int[][][] dp;
    private static String magic;
    private static String bridge1;
    private static String bridge2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        magic = br.readLine();
        bridge1 = br.readLine();
        bridge2 = br.readLine();

        dp = new int[magic.length() + 1][bridge1.length() + 1][3];

        for (int i = 1; i <= magic.length(); i++) {
            for (int j = 1; j <= bridge1.length(); j++) {
                for (int k = 1; k <= 2; k++) {//1:天使桥；  2：恶魔桥；
                    if (i == 1) {
                        if (j == 1) {
                            dp[1][1][k] = (getStep(j, k) == magic.charAt(i - 1)) ? 1 : 0;
                        } else {
                            dp[1][j][k] = dp[1][j - 1][k] + ((getStep(j, k) == magic.charAt(i - 1)) ? 1 : 0);

                        }
                    } else {
                        dp[i][j][k] = dp[i][j - 1][k] + ((getStep(j, k) == magic.charAt(i - 1)) ? dp[i - 1][j - 1][3 - k] : 0);
                    }
                }
            }
        }
        System.out.println(dp[magic.length()][bridge1.length()][1] + dp[magic.length()][bridge1.length()][2]);
    }

    private static char getStep(final int step, final int bridge) {
        return ((bridge == 1) ? bridge1.charAt(step - 1) : bridge2.charAt(step - 1));
    }

}
