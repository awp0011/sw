package sw.pro.armyline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    static int[] cash = new int[10005];
    static int[] firstLine = new int[10005];
    static int MOD = 100000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        for (int i = 1; i <= T; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 1; j <= temp.length; j++) {
                firstLine[j] = Integer.valueOf(temp[j - 1]);
            }
            System.out.println("#" + i + " " + solve(temp.length));
        }
        br.close();
    }

    static int solve(final int armyLength) {
        Arrays.fill(cash, 1, firstLine[armyLength] + 1, 1);
        cash[firstLine[armyLength] + 1] = 0;//
        for (int i = armyLength - 1; i > 0; i--) {
            for (int j = firstLine[i + 1]; j > 0; j--) {
                if (j > firstLine[i]) {
                    cash[j - 1] = (cash[j - 1] + cash[j]) % MOD;
                    cash[j] = 0;
                } else {
                    cash[j] = (cash[j] + cash[j + 1]) % MOD;
                }
            }
        }
        return cash[1];
    }
}
