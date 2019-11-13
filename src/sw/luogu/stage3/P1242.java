package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1242 {
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static final StringBuilder out = new StringBuilder();

    private static int n, x, ans, tar;
    private static int[] s = new int[50];
    private static int[] e = new int[50];

    public static void main(String[] args) throws IOException {
        in.nextToken();
        n = (int) in.nval;
        readCase(s);
        readCase(e);
        move(n, s[n], e[n], true);
        System.out.print(out.toString());
        System.out.println(ans);
    }

    private static void move(int d, int x, int y, boolean current) {
        int z = 1;
        while (x == z || z == y) z++;
        if (x == y) {//不需要移动
            if (d > 1) move(d - 1, s[d - 1], current ? e[d - 1] : y, current && true);
            return;
        }
        if (d > 1) move(d - 1, s[d - 1], z, false);
        out.append("move ").append(d).append(" from ").append((char) (x + '@'));
        out.append(" to ").append((char) (y + '@')).append('\n');
        ans++;
        s[d] = y;
        if (d > 1) move(d - 1, s[d - 1], current ? e[d - 1] : y, current && true);//当kk为真时大于等于当前的盘子已经处理完毕（处理剩余的盘子
    }

    private static void readCase(int[] a) throws IOException {
        for (int i = 1; i <= 3; i++) {
            in.nextToken();
            x = (int) in.nval;
            for (int j = 1; j <= x; j++) {
                in.nextToken();
                tar = (int) in.nval;
                a[tar] = i;
            }
        }
    }

}
