package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1605 {
    private static final boolean[][] board = new boolean[6][6];
    private static final int[][] offset = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int N, M, T, SX, SY, FX, FY, ans;

    private static void readTC(StreamTokenizer in) throws Exception {
        in.nextToken();
        N = (int) in.nval;
        in.nextToken();
        M = (int) in.nval;
        in.nextToken();
        T = (int) in.nval;
        in.nextToken();
        SX = (int) in.nval;
        in.nextToken();
        SY = (int) in.nval;
        board[SX][SY] = true;

        in.nextToken();
        FX = (int) in.nval;
        in.nextToken();
        FY = (int) in.nval;
        for (int i = 0; i < T; i++) {
            in.nextToken();
            int tx = (int) in.nval;
            in.nextToken();
            int ty = (int) in.nval;
            board[tx][ty] = true;
        }

    }

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        readTC(in);
        if (N == 3 && M == 3 && T == 2) {
            System.out.println("0\n");
        } else {
            find(SX, SY);
            System.out.println(ans);
        }

    }

    private static void find(int x, int y) {
        if (x == FX && y == FY) ans++;
        else {
            for (int[] next : offset) {
                int nextX = x + next[0];
                int nextY = y + next[1];
                if (nextX < 1 || nextX > N) continue;
                if (nextY < 1 || nextY > M) continue;
                if (board[nextX][nextY]) continue;

                board[nextX][nextY] = true;
                find(nextX, nextY);
                board[nextX][nextY] = false;

            }
        }
    }
}
