package sw.pro.SDS_PRO_4_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class source {
    private static Board[][] sheep;
    private static Queue<Board> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int ex = 0, ey = 0;
        sheep = new Board[H][W];
        for (int i = 0; i < H; i++) {
            String temp = bufferedReader.readLine();
            for (int j = 0; j < W; j++) {
                sheep[i][j] = new Board(i, j, temp.charAt(j));
                if (sheep[i][j].isStart()) queue.add(sheep[i][j]);
                if (sheep[i][j].isEnd()) {
                    ex = i;
                    ey = j;
                    sheep[i][j].cost = Integer.MAX_VALUE;
                }
            }
        }
        bufferedReader.close();
        while (!queue.isEmpty()) {
            Board board = queue.poll();
            //System.out.print("("+board.X+","+board.Y+")->");
            if (board.X > 0) walk(sheep[board.X - 1][board.Y], queue, board.cost);

            if (board.Y > 0) walk(sheep[board.X][board.Y - 1], queue, board.cost);

            if (board.X < H - 1) walk(sheep[board.X + 1][board.Y], queue, board.cost);

            if (board.Y < W - 1) walk(sheep[board.X][board.Y + 1], queue, board.cost);

            //System.out.println();
        }

        if (sheep[ex][ey].cost == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(sheep[ex][ey].cost);
    }

    private static void walk(Board next, Queue<Board> queue, int cost) {
        if (next.couldPass()) {
            //System.out.print("  ("+next.X+","+next.Y+")");
            next.pass(cost + 1);
            queue.add(next);
        }
        if (next.isEnd() && next.cost > (cost + 1)) next.cost = cost + 1;

    }

    private static class Board {
        int X, Y;
        int cost;
        char type;

        Board(int x, int y, char t) {
            X = x;
            Y = y;
            type = t;
        }

        boolean isEnd() {
            return type == 'E';
        }

        boolean isStart() {
            return type == 'S';
        }

        boolean couldPass() {
            return type == 'O';
        }

        void pass(int c) {
            cost = c;
            if (type == 'O') type = 'X';

        }

        boolean equals(Board other) {
            return (other != null) && (other.X == X) && (other.Y == Y);
        }
    }
}