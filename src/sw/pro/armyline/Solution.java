package sw.pro.armyline;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    static int[] cash = new int[10005];
    static int[] data;
    static int MOD = 100000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int i = 1; i <= T; i++) {
            String[] temp = sc.nextLine().split(" ");
            data = new int[temp.length + 1];
            for (int j = 1; j <= temp.length; j++) {
                data[j] = Integer.valueOf(temp[j - 1]);
            }
            System.out.println("#" + i + " " + solve());
        }
    }

    static int solve() {
        Arrays.fill(cash, 1);
        cash[data[data.length - 1] + 1] = 0;//
        for (int i = data.length - 2; i > 0; i--) {
            int temp = 0;
            for (int j = data[i + 1]; j > 0; j--) {
                if (j > data[i]) {
                    temp += cash[j] % MOD;
                    cash[j] = 0;
                } else {
                    cash[j] += cash[j + 1] % MOD;
                    if (temp > 0) {
                        cash[j] += temp % MOD;
                        temp = 0;
                    }
                }
            }
        }
        return cash[1];
    }
}
