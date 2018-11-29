package sw.pro.SDS_PRO_7_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.util.Arrays.fill;

public class source {
    private final static char EMPTY = 'E';
    private final static int INF = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] cards = new char[N + 1];
        for (int i = 1; i <= N; i++) {
            cards[i] = st.nextToken().charAt(0);
        }
        st = new StringTokenizer(br.readLine());
        int M = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());
        char[][] board = new char[M + 1][M + 1];
        for (int i = 1; i <= M; i++) {
            fill(board[i], EMPTY);
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            board[x][y] = st.nextToken().charAt(0);
            board[y][x] = board[x][y];
        }
        int[][][] map = new int[N + 1][M + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                fill(map[i][j], INF);
            }
        }
        for (int i = 1; i <= M; i++) {
            if (board[1][i] != EMPTY) map[1][1][i] = board[1][i] == cards[1] ? 10 : 0;

        }
        for (int k = 2; k <= N; k++) {//cards[i]
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= M; j++) {
                    if (map[k - 1][i][j] == INF) continue;
                    for (int l = 1; l <= M; l++) {
                        if (board[j][l] == EMPTY) continue;
                        if (board[j][l] == cards[k]) {
                            map[k][j][l] = max(map[k - 1][i][j] + 10, map[k][j][l]);
                        } else {
                            map[k][j][l] = max(map[k - 1][i][j], map[k][j][l]);
                        }
//                        map[k][j][l] = (board[j][l] == cards[k]) ?
//                                max(map[k - 1][i][j] + 10, map[k][j][l]) :
//                                max(map[k - 1][i][j], map[k][j][l]);
                        //System.out.print((k - 1) + " " + i + " " + j + " :" + map[k - 1][i][j] + " --> ");
                        //System.out.println(k + " " + j + " " + l + " :" + map[k][j][l]);
                    }
                }
            }
        }
        int Max = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[N][i][j] == INF) continue;
                Max = max(Max, map[N][i][j]);
            }

        }
        System.out.println(Max);
    }
}