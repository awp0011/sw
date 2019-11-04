package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1363Pro {
    private static final short[][] offset = new short[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
    private static boolean found;
    private static boolean[][] d ;
    private static short N, M, sx, sy;
    private static short[][][] visited ;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\1.txt"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.ordinaryChar('.');
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            N = (short) in.nval;
            in.nextToken();
            M = (short) in.nval;
            d = new boolean[N+1][M+1];
            visited = new short[N+1][M+1][3];
            for (short i = 0; i < N; i++) {
                for (short j = 0; j < M; j++) {
                    visited[i][j][0] = 0;
                    visited[i][j][1] = 0;
                    visited[i][j][2] = 0;
                    in.nextToken();
                    switch (in.ttype) {
                        case StreamTokenizer.TT_WORD:
                            sx = i;
                            sy = j;
                            break;
                        default:
                            d[i][j] = (35 == in.ttype);
                    }
                }
            }
            found = false;
            dfs(sx, sy, sx, sy);
            if (found) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    private static void dfs(short x, short y, short lx, short ly) {
        if (found) return;
        if (visited[x][y][0] == 1 && (visited[x][y][1] != lx || visited[x][y][2] != ly)) {
            found = true;
            return;
        }
        visited[x][y][1] = lx;
        visited[x][y][2] = ly;
        visited[x][y][0] = 1;
        for (int i = 0; i < 4; ++i) {
            short xx = (short) ((x + offset[i][0] + N) % N);
            short yy = (short) ((y + offset[i][1] + M) % M);
            short lxx = (short) (lx + offset[i][0]);
            short lyy = (short) (ly + offset[i][1]);
            if (!d[xx][yy]) {
                if (visited[xx][yy][1] != lxx || visited[xx][yy][2] != lyy || visited[xx][yy][0] == 0)
                    dfs(xx, yy, lxx, lyy);
            }
        }
    }
}
