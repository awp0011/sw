package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//#-->35
//.-->46
//S-->83
public class P1363 {
    private static int N, M, sx, sy,index;
    private static boolean found;
    private static final int[][][] visitor = new int[1505][1505][2];
    private static final boolean[][] map = new boolean[1505][1505];
    private static final boolean[][] visited = new boolean[1505][1505];
    private static final int[][] offset = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\1.txt"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.ordinaryChar('.');
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            N = (int) in.nval;
            in.nextToken();
            M = (int) in.nval;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    visitor[i][j][0] = 0;
                    visitor[i][j][1] = 0;
                    visited[i][j] = false;
                    in.nextToken();
                    switch (in.ttype) {
                        case StreamTokenizer.TT_WORD:
                            sx = i;
                            sy = j;
                            map[i][j] = true;
                            break;
                        default:
                            map[i][j] = (46 == in.ttype);
                    }
                }
            }
            found = false;
            index=0;
            dfs(sx, sy, sx, sy);
            if (found) System.out.println("Yes");
            else System.out.println("No");
        }

    }

    private static void dfs(int x, int y, int xx, int yy) {
        System.out.println("idx:"+index+"\tx:"+x+"\ty:"+y+"\txx:"+xx+"\tyy:"+yy);
        index++;
        if (found) return;
        if (visited[x][y] && (visitor[x][y][0] != xx || visitor[x][y][1] != yy)) {
            found = true;
            return;
        }
        visited[x][y] = true;
        visitor[x][y][0] = xx;
        visitor[x][y][1] = yy;
        for (int[] next : offset) {
            int nx = (x + next[0] + N) % N, ny = (y + next[1] + M) % M;
            if (map[nx][ny]) {
                int nxx = (xx + next[0]), nyy = (yy + next[1]);
                if (visitor[nx][ny][0] != nxx || visitor[nx][ny][1] != nyy || !visited[nx][nx]) dfs(nx, ny, nxx, nyy);
            }
        }
    }

}
