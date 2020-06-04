package sw.luogu.stage5.P5461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static boolean[][] map;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int base = (int) Math.pow(2, n);
        map = new boolean[base][base];
        bin(0, base, 0, base);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < base; i++) {
            for (int j = 0; j < base; j++) {
                ans.append(map[i][j] ? 1 : 0).append(' ');
            }
            ans.append('\n');
        }
        System.out.println(ans.toString());
    }

    private static void bin(int xs, int xe, int ys, int ye) {
        if (xe - xs == 1) map[xs][ys] = true;
        else {
            bin(xs + (xe - xs) / 2, xe, ys, ys + (ye - ys) / 2);//左下
            bin(xs, xs + (xe - xs) / 2, ys + (ye - ys) / 2, ye);//右上
            bin(xs + (xe - xs) / 2, xe, ys + (ye - ys) / 2, ye);//右下
        }
    }
}
