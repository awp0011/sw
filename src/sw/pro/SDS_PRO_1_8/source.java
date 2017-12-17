package sw.pro.SDS_PRO_1_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    private static int  N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Box[][] board = new Box[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = new Box(i, j, Integer.parseInt(st.nextToken()));
                if (i > 0) {
                    unionFind(board[i][j], board[i - 1][j]);
                }

                if (j > 0) {
                    unionFind(board[i][j], board[i][j - 1]);
                }

            }
        }
        br.close();


        int answer_white = 0, answer_black = 0;
        int white_index = -1, black_index = -1;
        for (int i = 0; i < N - 1; i++) {
            if (board[0][i].color == 0) {
                if (find(board[0][i]).parent.index != white_index) {
                    answer_white++;
                    white_index = board[0][i].parent.index;
                }
            } else {
                if (find(board[0][i]).parent.index != black_index) {
                    answer_black++;
                    black_index = board[0][i].parent.index;
                }
            }
        }
        System.out.println(Math.min(answer_black, answer_white));
//        System.out.println("-------");
//        for (int i = 0; i < M; i++) {
//            for (int j = 0; j < N; j++) {
//                System.out.print(board[i][j].parent.index + " ");
//            }
//            System.out.println();
//        }
    }

    private static void unionFind(final Box p, final Box q) {

        if (p.color != q.color)
            return;
        if (find(p).equals(find(q)))
            return;
        if (p.parent.index < q.parent.index) {
            q.parent.parent = p.parent.parent;
        } else {
            p.parent.parent = q.parent.parent;
        }
    }

    private static Box find(final Box box) {
        if (box.equals(box.parent))
            return box.parent;
        box.parent = find(box.parent);
        return box.parent;
    }

    private static class Box {
        int index;
        int color;
        Box parent;

        Box(final int i, final int j, final int c) {
            index = i * N + j;
            color = c;
            parent = this;
        }

        boolean equals(final Box other) {
            return other != null && other.index == index;
        }
    }
}