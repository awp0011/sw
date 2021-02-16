package sw.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static void main(String[] args) {

    }

    private static final int[][] f = new int[102][102];
    private static final int[][] ab = new int[2][602];

    public static int findMaxForm(String[] strs, int m, int n) {
        for (int i = 0; i <= 101; i++) Arrays.fill(f[i], 0);
        Arrays.fill(ab[0], 0);
        Arrays.fill(ab[1], 0);
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                if (c == '0') ab[0][i]++;
                else ab[1][i]++;
            }
        }
        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= ab[0][i]; j--) {
                for (int k = n; k >= ab[1][i]; k--) {
                    f[j][k] = Math.max(f[j][k], f[j - ab[0][i]][k - ab[1][i]] + 1);
                }
            }
        }
        return f[m][n];
    }

}
