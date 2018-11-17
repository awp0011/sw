package sw.adv.fold.table;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private final static int[][] pool = new int[101][101];
    private static int MAX, MIN;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder(100);
        int R, C, tmp;
        StringTokenizer st;
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            MAX = Integer.MIN_VALUE;
            MIN = Integer.MAX_VALUE;
            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    tmp = Integer.parseInt(st.nextToken());
                    pool[i][j] = tmp;
                    MAX = Math.max(MAX, tmp);
                    MIN = Math.min(MIN, tmp);
                }
            }
            outputMaxMin(sb);
            System.out.println("#" + t + " " + fold(R, C, sb) + sb.toString());
            sb.delete(0, sb.length() + 1);
        }
        long endTime = System.currentTimeMillis();
        //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static int fold(int rows, int columns, StringBuilder stringBuilder) {
        int r = rows;
        int c = columns;
        int cnt = 0;
        while (!(r % 2 == 1 && c % 2 == 1)) {
            if (r % 2 == 0 && c % 2 == 0) {
                if (r == c) {
                    foldH(r, c);
                    c >>= 1;
                } else {
                    if (r > c) {
                        foldV(r, c);
                        r >>= 1;
                    } else {
                        foldH(r, c);
                        c >>= 1;
                    }
                }
            } else if (r % 2 == 0) {
                foldV(r, c);
                r >>= 1;
            } else if (c % 2 == 0) {

                foldH(r, c);
                c >>= 1;
            }
            cnt++;
            outputMaxMin(stringBuilder);
        }
        return cnt;

    }

    private static void foldH(int r, int c) {
        int end = c >> 1;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < end; j++) {
                pool[i][j] += pool[i][c - j - 1];
                MAX = Math.max(MAX, pool[i][j]);
                MIN = Math.min(MIN, pool[i][j]);
            }
        }
    }

    private static void foldV(int r, int c) {
        int end = r >> 1;
        for (int i = 0; i < end; i++) {
            for (int j = 0; j < c; j++) {
                pool[i][j] += pool[r - i - 1][j];
                MAX = Math.max(MAX, pool[i][j]);
                MIN = Math.min(MIN, pool[i][j]);
            }
        }
    }

    private static void outputMaxMin(StringBuilder stringBuilder) {
        stringBuilder.append(' ').append(MAX).append(' ').append(MIN);
        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;
    }
}