package sw.pro.SQUARE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source_dp {
    private static int[][][] board;
    private static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N][2];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j][0] = Integer.parseInt(st.nextToken());
                if (i - 1 < 0 || j - 1 < 0) continue;
                if (board[i - 1][j][0] == 1
                        && board[i][j - 1][0] == 1
                        && board[i - 1][j - 1][0] == 1
                        && board[i][j][0] == 1) {
                    board[i][j][1] = 1 + min(board[i - 1][j - 1][1], board[i - 1][j][1], board[i][j - 1][1]);
                    answer += board[i][j][1];
                }
            }
        }
        br.close();
        System.out.println(answer);
    }

    private static int min(final int a, final int b, final int c) {
        return Math.min(a, Math.min(b, c));
    }

}
