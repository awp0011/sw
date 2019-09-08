package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class P1092 {
    private static final int[][] data = new int[3][30];
    private static final int[] base = new int[30];
    private static final boolean[] isUsed = new boolean[30];
    private static int n, found;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < 3; i++) {
            in.nextToken();
            for (int j = 1; j <= n; j++) {
                data[i][j] = (in.sval.charAt(j - 1) - 'A') + 1;
            }
        }
        Arrays.fill(base, -1);
        found = 0;
        //find(1, 0);
        dfs(0, n, 0);
    }

    /*
     x 是行
     y 是列
     c 是进位
    */
    private static void dfs(int x, int y, int c) {
        if (found == 1) return;
        if (y == 0) {
            if (c == 0) {
                for (int j = 1; j < n; j++) {
                    System.out.print(base[j] + " ");
                }
                System.out.println(base[n]);
                found = 1;
            }
            return;
        }
        for (int i = x - 1; i >= 1; i--) {
            int x1 = base[data[0][i]]; //第一行代表的数字
            int x2 = base[data[1][i]]; //第二行代表的数字
            int x3 = base[data[2][i]]; //第三行代表的数字
            if (x1 == -1 || x2 == -1 || x3 == -1)
                continue;
            if ((x1 + x2) % n != x3 && (x1 + x2 + 1) % n != x3)
                return;
        }
        if (base[data[x][y]] == -1) {
            for (int i = n - 1; i >= 0; i--) {
                if (!isUsed[i]) {
                    if (x != 2) {
                        isUsed[i] = true;
                        base[data[x][y]] = i;
                        dfs(x + 1, y, c);
                        isUsed[i] = false;
                        base[data[x][y]] = -1;
                    } else {
                        int sum = base[data[0][y]] + base[data[1][y]] + c;
                        if (sum % n != i) continue;
                        isUsed[i] = true;
                        base[data[x][y]] = i;
                        dfs(0, y - 1, sum / n);// 搜索下一列，进位需要改变
                        isUsed[i] = false;
                        base[data[x][y]] = -1;
                    }

                }
            }
        } else {
            if (x != 2) {
                dfs(x + 1, y, c);
            } else {
                int sum = base[data[0][y]] + base[data[1][y]] + c;
                if (sum % n != base[data[2][y]]) return;
                dfs(0, y - 1, sum / n);// 搜索下一列，进位需要改变
            }

        }
    }

}
