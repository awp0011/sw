package sw.luogu.stage3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1242Ex {
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static final StringBuilder out = new StringBuilder();
    private static final int N = 50;
    private static final int[] s = new int[50];
    private static final int[] e = new int[50];
    private static final int[] a = new int[50];
    private static final int[] cnt = new int[3];
    private static boolean print;
    private static int k;
    private static int p;
    private static int cal;

    public static void main(String[] args) throws IOException {
        in.nextToken();
        //cal表示当前是第几种方案，print表示当前调用move函数是否要打印答案；两种方案对应@maoxiaozhukai的题解里的两种方案
        int n = (int) in.nval;
        readCase(s);
        readCase(e);

        p = n;
        while (s[p] == e[p]) p--;
        print = false;
        cal = 1;//计算方案1的移动次数
        work(1);
        cal = 2;//计算方案2的移动次数
        work(2);

        print = true;//输出
        cal = cnt[1] <= cnt[2] ? 1 : 2;
        work(cal);

        System.out.print(out.toString());
        System.out.println(cnt[cal]);
    }

    private static void work(int op) {//还是结构式代码简洁
        System.arraycopy(s, 0, a, 0, 50);
        switch (op) {
            case 1:
                for (int i = p; i > 0; i--)
                    if (a[i] != e[i]) move(i, a[i], e[i]);
                break;

            case 2://第2种方案有5步，前4步是上面介绍的题解里方案2的4步，最后一步是把1~n-1的盘子移到它们的目标位置上
                for (int i = p - 1; i > 0; i--)
                    if (a[i] != e[p]) move(i, a[i], e[p]);
                move(p, s[p], 6 - s[p] - e[p]);
                for (int i = p - 1; i > 0; i--)
                    if (a[i] != s[p]) move(i, a[i], s[p]);
                move(p, 6 - s[p] - e[p], e[p]);
                for (int i = p - 1; i > 0; i--)
                    if (a[i] != e[i]) move(i, a[i], e[i]);
                break;
        }
    }

    private static void move(int x, int from, int to) {
        for (int i = x - 1; i > 0; i--) {
            if (a[i] != 6 - from - to) move(i, a[i], 6 - from - to);
        }
        a[x] = to;
        if (print) {
            out.append("move ").append(x).append(" from ").append((char) (from + '@'));
            out.append(" to ").append((char) (to + '@')).append('\n');
        } else cnt[cal]++;
    }

    private static void readCase(int[] a) throws IOException {
        for (int i = 1; i <= 3; i++) {
            in.nextToken();
            int x = (int) in.nval;
            for (int j = 1; j <= x; j++) {
                in.nextToken();
                a[(int) in.nval] = i;
            }
        }
    }

}
