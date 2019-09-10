package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

import static java.lang.Math.min;

public class P1162 {
    private static int n;
    private static final int[][][] data = new int[30][30][3];
    private static final int[][] offset = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                in.nextToken();
                data[i][j][0] = (int) (in.nval);
                data[i][j][1] = i * n + j;
                data[i][j][2] = (int) (in.nval);
                if (data[i][j][0] == 0) {
                    for (int k = 2; k < 4; k++) {
                        int nextX = i + offset[k][0];
                        int nextY = j + offset[k][1];
                        if (nextX < 0 || nextX >= n) data[i][j][2] = -1;
                        else if (nextY < 0 || nextY >= n) data[i][j][2] = -1;
                    }
                    for (int k = 0; k < 2; k++) {
                        int nextX = i + offset[k][0];
                        int nextY = j + offset[k][1];
                        if (nextX < 0 || nextX >= n) data[i][j][2] = -1;
                        else if (nextY < 0 || nextY >= n) data[i][j][2] = -1;
                        else {
                            if (data[nextX][nextY][0] == 0) union(i, j, nextX, nextY);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (data[i][j][0] == 0) {
                    int p = find(i, j);
                    int x = p / n;
                    int y = p % n;
                    if (data[x][y][2] == -1) System.out.print(data[i][j][0] + " ");
                    else System.out.print("2 ");
                } else {
                    System.out.print(data[i][j][0] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int find(int x, int y) {
        int index = x * n + y;
        if (index == data[x][y][1]) return index;
        return data[x][y][1] = find(data[x][y][1] / n, data[x][y][1] % n);
    }

    private static void union(int x1, int y1, int x2, int y2) {
        int p1 = find(x1, y1);
        int p2 = find(x2, y2);
        if (p1 == p2) return;
        int p1x = p1 / n;
        int p1y = p1 % n;
        int p2x = p2 / n;
        int p2y = p2 % n;
        int min1 = min(data[x1][y1][2], data[x2][y2][2]);
        int min2 = min(data[p1x][p1y][2], data[p2x][p2y][2]);
        int min = min(min1, min2);
        if (p1 > p2) {
            data[p1x][p1y][1] = p2;
        } else {
            data[p2x][p2y][1] = p1;
        }
        data[p1x][p1y][2] = min;
        data[p2x][p2y][2] = min;
    }
}
