package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class P1058 {
    private static final String[] c1 = new String[]{
            "  +---+",
            " /   /|",
            "+---+ |",
            "|   | +",
            "|   |/",
            "+---+"
    };
    private static final int[] z = new int[]{2, 1, 0, 0, 0, 0};
    private static final int[] s = new int[]{6, 6, 6, 6, 5, 4};
    private static final char[][] c = new char[1001][1001];
    private static int maxx = 0, maxy = 0;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int M = (int) in.nval;
        in.nextToken();
        int N = (int) in.nval;

        int[][] map = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < N; j++) {
                in.nextToken();
                map[i][j] = (int) in.nval;
            }
        }
        for (char[] line : c) {
            Arrays.fill(line, '.');
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < map[i][j]; k++) {
                    draw((M - i) * 2 + 1 + 2 * k, (M - i) * 2 + 1 + 4 * j);
                }
            }
        }
//        StringBuilder ans = new StringBuilder();
//        for (int i = maxx; i >= 1; i--) {
//            for (int j = 1; j <= maxy; j++) {
//                ans.append(0 == (int) c[i][j] ? '.' : c[i][j]);
//            }
//            ans.append('\n');
//        }
//        System.out.println(ans.toString());
        for (int i = maxx; i >= 1; i--) {
            for (int j = 1; j <= maxy; j++) {
                System.out.print(0 == (int) c[i][j] ? '.' : c[i][j]);
            }
            System.out.println();
        }

    }

    private static void draw(int x, int y) {
        for (int i = 5; i >= 0; i--)
            for (int j = z[i]; j <= s[i]; j++) {
                c[5 - i + x][j + y] = c1[i].charAt(j);
                if (5 - i + x > maxx) maxx = 5 - i + x;
                if (j + y > maxy) maxy = j + y;
            }
    }
}
