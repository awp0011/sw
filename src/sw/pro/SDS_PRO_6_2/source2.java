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
                        dp[1][j][k] = dp[1][j - 1][k] + (isMatchMagic(i, j, k) ? 1 : 0);
                    } else {
                        dp[i][j][k] = dp[i][j - 1][k] + (isMatchMagic(i, j, k) ? dp[i - 1][j - 1][3 - k] : 0);
                    }
                    //if(k==2) System.out.print(dp[i][j][k]+" ");
                }
            }
            //System.out.println();
        }
        System.out.println(dp[magic.length()][bridge1.length()][1] + dp[magic.length()][bridge1.length()][2]);
    }

    private static boolean isMatchMagic(final int magic_index, final int bridge_index, final int brideg) {
        return ((brideg == 1) ? bridge1.charAt(bridge_index - 1) : bridge2.charAt(bridge_index - 1)) == magic.charAt(magic_index - 1);
    }
    
}
