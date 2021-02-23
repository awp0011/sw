package sw.pro.lca;

import java.io.IOException;

public class Template {
    private static final int MAX_N = 300000;
    private static final int MAX_L = (int) (Math.log(MAX_N) / Math.log(2));
    private static final int[][] p = new int[MAX_L + 1][MAX_N + 3];

    public static void main(String[] args) throws IOException {

        initCase();
        dfs(1);
        //前置算法RMQ
        for (int j = 1; j <= MAX_L; j++) {
            for (int i = 1; i <= MAX_N; i++) {
                p[j][i] = p[j - 1][p[i][j - 1]];
            }
        }
        int a = 0, b = 0;
        lca(a, b);

    }

    private static void initCase() {

    }

    private static void dfs(int p) {

    }

    private static int lca(int a, int b) {
        int p = 0;

        return p;
    }
}
