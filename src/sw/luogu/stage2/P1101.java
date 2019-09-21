package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;

public class P1101 {
    private static final char[][] board = new char[100][100];
    private static final boolean[][] shadow = new boolean[100][100];
    private static final ArrayDeque<Integer> Q = new ArrayDeque<>();
    private static final int[][] offset = new int[][]{
            {0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
    };
    private static final char[] target = "yizhong".toCharArray();
    private static int n;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            char[] tmp = in.sval.toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = tmp[j];
                if (board[i][j] == 'y') Q.add(i * n + j);
            }
        }
        while (!Q.isEmpty()) {
            int start = Q.poll();
            for (int[] next : offset) find(start, next);
        }
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (shadow[i][j]) ans.append(board[i][j]);
                else ans.append('*');
            }
            ans.append('\n');
        }
        System.out.print(ans.toString());
    }

    private static void find(int index, int[] dict) {
        int x = index / n;
        int y = index % n;
        for (int i = 1; i <= 6; i++) {
            x += dict[0];
            y += dict[1];
            if (x < 0 || x >= n) return;
            if (y < 0 || y >= n) return;
            if (board[x][y] != target[i]) return;
        }
        x = index / n;
        y = index % n;
        for (int i = 0; i <= 6; i++) {
            shadow[x][y] = true;
            x += dict[0];
            y += dict[1];
        }
    }
}
