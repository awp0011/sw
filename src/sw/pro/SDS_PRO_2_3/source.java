package sw.pro.SDS_PRO_2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    private static Box[][] board = new Box[10][10];


    public static void main(String[] args) throws Exception {
        int M, N;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = new Box(i, j);
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int x, y;
        for (int i = 0; i < C; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken()) - 1;
            N = Integer.parseInt(st.nextToken()) - 1;
            for (x = 0; x <= M; x++) {
                char[] flags = br.readLine().toCharArray();
                for (y = 0; y <= N; y++) board[x][y].init(flags[y]);
                if (y < 9) {
                    board[x][y + 1].init('.');
                }
            }
            int answer1 = 0;
            for (x = 0; x <= M; x++) {
                y = 0;
                while (y <= N) {
                    if (board[x][y].couldBeKnight()) {
                        board[x][y].isKnight = true;
                        answer1++;
                        y++;
                    }
                    y++;
                }
            }
//            System.out.println("-----------------");
//            Arrays.stream(board).forEach(row -> {
//                Arrays.stream(row).forEach(c -> {
//                    if (c.isKnight) System.out.print('K');
//                    else if (!c.isAccessed) System.out.print('x');
//                    else System.out.print('.');
//                });
//                System.out.println();
//            });
//            System.out.println("-----------------");

            for (x = 0; x <= M; x++) for (y = 0; y <= N; y++) board[x][y].isKnight = false;
            int answer2 = 0;
            for (int j = 0; j < N; j++)
                for (int k = 0; k < M; k++)
                    if (board[k][j].couldBeKnight()) {
                        board[k][j].isKnight = true;
                        answer2++;
                        k++;
                    }
            System.out.println(Math.max(answer1, answer2));

        }
        br.close();
    }

    private static class Box {
        int X, Y;
        Box topLeft, topRight, left, right;
        boolean isKnight, isAccessed;

        Box(final int x, final int y) {
            X = x;
            Y = y;
            init('.');


        }

        void init(final char flag) {
            isKnight = false;
            isAccessed = '.' == flag;
        }

        boolean couldBeKnight() {
            makeAround();
            return (isAccessed)
                    && ((topLeft == null) || !topLeft.isKnight)
                    && ((left == null) || !left.isKnight)
                    && ((topRight == null) || !topRight.isKnight)
                    && ((right == null) || !right.isKnight);

        }

        void makeAround() {
            if (Y > 0) {
                if (X > 0) {
                    topLeft = board[X - 1][Y - 1];
                }
                left = board[X][Y - 1];
            }

            if (Y < 9) {
                if (X > 0) {
                    topRight = board[X - 1][Y + 1];
                }
                right = board[X][Y + 1];
            }
        }

    }
}
