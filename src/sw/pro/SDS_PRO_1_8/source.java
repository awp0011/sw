package sw.pro.SDS_PRO_1_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    private static int N;

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
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (i > 0) {
                    unionFind(board[i][j], board[i - 1][j]);

                }
                if (i < M - 1) {
                    unionFind(board[i][j], board[i + 1][j]);
                }
                if (j > 0) {
                    unionFind(board[i][j], board[i][j - 1]);

                }
                if (j < N - 1) {
                    unionFind(board[i][j], board[i][j + 1]);
                }
            }
        }
        br.close();


        int answer_white = 0, answer_black = 0;
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
//                System.out.print(board[j][i].color + "(" + board[j][i].parent.index + ") ");
                if (board[j][i].index == board[j][i].parent.index) {
                    if (board[j][i].color == 0) {
                        answer_white++;
                    } else {
                        answer_black++;
                    }
                }
            }
//            System.out.println();

        }
        //System.out.println(answer_black+" "+answer_white);
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