package sw.pro.SDS_PRO_6_2;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source3 {
    private static int[][][] dp;
    private static boolean[][][] visited;
    private static String magic;
    private static String bridge1;
    private static String bridge2;
    private static int M, B;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        magic = br.readLine();
        bridge1 = br.readLine();
        bridge2 = br.readLine();
        M = magic.length() - 1;
        B = bridge1.length();

        dp = new int[magic.length() + 1][bridge1.length() + 1][3];
        visited = new boolean[magic.length() + 1][bridge1.length() + 1][3];
        System.out.println(cross(0, 0, 1)+ cross(0, 0, 2));
    }

    private static boolean isMatchMagic(final int magic_index, final int bridge_index, final int bridge) {
        return (((bridge == 1) ? bridge1.charAt(bridge_index) : bridge2.charAt(bridge_index)) == magic.charAt(magic_index));
    }

    private static int cross(int magic_index, int bridge_index, int bridge) {
        if (bridge_index >= B) return 0;
        int sum = 0;
        for (int j = bridge_index; j < B; j++) {
            if (isMatchMagic(magic_index, j, bridge)) {

                if (!visited[magic_index][j][bridge]) {
                    if (magic_index == M) {
                        dp[magic_index][j][bridge] = 1;
                    } else {
                        dp[magic_index][j][bridge] = cross((magic_index + 1), (j + 1), (3 - bridge));
                    }

                }
                visited[magic_index][j][bridge] = true;
                sum += dp[magic_index][j][bridge];
            }
        }
        return sum;
    }

}
