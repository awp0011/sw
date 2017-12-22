package sw.pro.SQUARE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class source {
    private static List<Square> current, next;
    private static Square[][] board;
    private static int N;
    private static int data[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new Square[N][N];
        next = new ArrayList<>(N * N);
        data = new int[251];
        data[0] = 0;
        data[1] = 0;
        data[2] = 1;
        List<Square> queue = new ArrayList<>(N * N);
        for (int i = 0; i < board.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < board.length; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 0)
                    continue;
                board[i][j] = new Square(i, j);

                if (i > 0 && board[i - 1][j] != null) {
                    board[i - 1][j].cntOf1++;
                }
                if (j > 0 && board[i][j - 1] != null) {
                    board[i][j - 1].cntOf1++;
                }
                if (i > 0 && j > 0 && board[i - 1][j - 1] != null) {
                    board[i - 1][j - 1].cntOf1++;
                }
                queue.add(board[i][j]);
            }
        }
        br.close();
        int answer = 0;
        for (Square s : queue) {
            if (s.cntOf1 == 3 && !s.isVisited) answer += getBlockCnt(count(s));
        }
        System.out.println(answer);
    }

    private static int count(final Square start) {
        int cnt = 0;
        boolean isClose = false;
        do {
            cnt++;
            next.clear();
            int row = start.X + cnt;
            int column = start.Y + cnt;
            if (row < N && column < N) {
                for (int i = start.Y; i <= column; i++) {
                    if (board[row][i] == null) {
                        isClose = true;
                        cnt--;
                        break;
                    }
                }
                if (!isClose) {
                    for (int i = start.X; i <= row; i++) {
                        if (board[i][column] == null) {
                            isClose = true;
                            cnt--;
                            break;
                        }
                    }
                }
                if (!isClose) {
                    for (int i = start.Y; i <= column; i++) {
                        board[row][i].isVisited = true;
                    }
                    for (int i = start.X; i <= row; i++) {
                        board[i][column].isVisited = true;
                    }
                }
            } else {
                cnt--;
                break;
            }
        } while (!isClose);
        return cnt;
    }

    private static int getBlockCnt(final int n) {
        if (data[n] != 0) return data[n];
        data[n] = (n - 1) * (n - 1) + getBlockCnt(n - 1);
        return data[n];
    }

    private static class Square {
        final int X, Y;
        int cntOf1;
        boolean isVisited;

        Square(final int x, final int y) {
            X = x;
            Y = y;
            cntOf1 = 0;
            isVisited = false;
        }
    }
}
