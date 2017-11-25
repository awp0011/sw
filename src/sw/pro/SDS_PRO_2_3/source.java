package sw.pro.SDS_PRO_2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    private static Box[][] board = new Box[10][10];


    public static void main(String[] args) throws Exception {
        int M, N;
        int answer;
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
            answer = 0;
            for (x = 0; x <= M; x++) {
                y = 0;
                while (y <= N) {
                    if (board[x][y].couldBeKnight()) {
                        board[x][y].isKnight = true;
                        answer++;
                        y++;
                    }
                    y++;
                }
            }
            System.out.println(answer);
//            System.out.println("-----------------");
//            Arrays.stream(board).forEach(row -> {
//                Arrays.stream(row).forEach(c -> {
//                    if (c.isKnight)                   System.out.print('K');
//                    else if(!c.isAccessed) System.out.print('x');
//                    else System.out.print('.');
//                });
//                System.out.println();
//            });
//            System.out.println("-----------------");
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

            if (y > 0) {
                if (x > 0) {
                    topLeft = board[x - 1][y - 1];
                }
                left = board[x][y - 1];
            }

            if (y < 9) {
                if (x > 0) {
                    topRight = board[x - 1][y + 1];
                }
                right = board[x][y + 1];
            }
        }

        void init(final char flag) {
            isKnight = false;
            isAccessed = '.' == flag;
        }

        boolean couldBeKnight() {

            if (isAccessed) if ((topLeft == null) || !topLeft.isKnight) if ((left == null) || !left.isKnight)
                if ((topRight == null) || !topRight.isKnight) if ((right == null) || !right.isKnight) return true;
            return false;

        }

    }
}
