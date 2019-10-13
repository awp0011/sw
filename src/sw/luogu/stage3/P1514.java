package sw.luogu.stage3;

import java.io.*;
import java.util.ArrayDeque;

public class P1514 {
    private static short[][] offset = new short[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static short[][][] map;
    private static short n, m, cnt;
    private static boolean[][] vis;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata (4).in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (short) in.nval;
        in.nextToken();
        m = (short) in.nval;
        cnt = m;
        map = new short[n][m][3];
        vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                in.nextToken();
                map[i][j][0] = (short) in.nval;
                map[i][j][1] = m;
                map[i][j][2] = -1;

            }
        }
        for (short j = 0; j < m; j++) {
            map[n - 1][j][1] = j;
            map[n - 1][j][2] = j;

        }
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < m; i++) {
            if (!vis[0][i]) dq.add(new int[]{0, i});
            while (!dq.isEmpty()) {
                int[] c = dq.peek();
                vis[c[0]][c[1]] = true;
                index = 0;
                for (; index < 4; index++) {
                    int nx = c[0] + offset[index][0];
                    int ny = c[1] + offset[index][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (map[nx][ny][0] >= map[c[0]][c[1]][0]) continue;
                    if (!vis[nx][ny]) {
                        dq.add(new int[]{nx, ny});
                        break;
                    }
                }
                if (index == 4) {
                    c = dq.pop();
                    int[] p = dq.peek();
                    if(p==null) continue;
                    map[p[0]][p[1]][1] = (short)Math.min(map[p[0]][p[1]][1], map[c[0]][c[1]][1]);
                    map[p[0]][p[1]][2] = (short)Math.max(map[p[0]][p[1]][2], map[c[0]][c[1]][2]);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            if (!vis[n - 1][i]) {
                cnt++;
            }
        }
        if (cnt > 0) {
            System.out.println("0\n" + cnt);
        } else {
            int left = 0, p = 0;
            while (left < m && cnt == 0) {
                int maxr = 0;
                for (int i = 0; i < m; i++)
                    if (map[0][i][1] <= left)
                        maxr = Math.max(maxr, map[0][i][2]);
                p++;
                left = maxr + 1;
            }
            System.out.println("1\n" + p);
        }

    }

//    private static void dfs(int x, int y) {
//        vis[x][y] = true;
//        for (int[] next : offset) {
//            int nx = x + next[0];
//            int ny = y + next[1];
//            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
//            if (map[nx][ny][0] >= map[x][y][0]) continue;
//            if (!vis[nx][ny]) dfs(nx, ny);
//            map[x][y][1] = Math.min(map[x][y][1], map[nx][ny][1]);
//            map[x][y][2] = Math.max(map[x][y][2], map[nx][ny][2]);
//        }
//    }
}
