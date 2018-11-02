package sw.pro.armyline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    private static int[] firstLine = new int[10005];
    private static int[] secondLine = new int[10005];
    private static int length  = 0;
    private static int MOD = 100000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        for (int i = 1; i <= T; i++) {
            length = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= length; j++) {
                firstLine[j] = Integer.valueOf(st.nextToken());
            }
            System.out.println("#" + i + " " + solve(length));
        }
        br.close();
    }

    private static int solve(final int armyLength) {
        Arrays.fill(secondLine, 1, firstLine[armyLength] + 1, 1);
        secondLine[firstLine[armyLength] + 1] = 0;//
        for (int i = armyLength - 1; i > 0; i--) {
            for (int j = firstLine[i + 1]; j > 0; j--) {
                if (j > firstLine[i]) {
                    secondLine[j - 1] = (secondLine[j - 1] + secondLine[j]) % MOD;
                    secondLine[j] = 0;
                } else {
                    secondLine[j] = (secondLine[j] + secondLine[j + 1]) % MOD;
                }
            }
        }
        return secondLine[1];
    }
}
