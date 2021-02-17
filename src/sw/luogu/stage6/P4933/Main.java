package sw.luogu.stage6.P4933;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static StreamTokenizer in;
    private static final int MOD = 998244353;
    private static final int V = 20000;

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        int[] a = new int[n + 2];
        for (int i = 1; i <= n; i++) a[i] = nextInt();
        int ans = 0;
        //f[i][j] 表示以 i 结尾公差为 ai-aj 的等差数列个数
        int[][] f = new int[n + 1][40003];
        for (int i = 1; i <= n; i++) {
            ans++;//自己也是等差数列
            for (int j = i - 1; j > 0; j--) {
                int cp = a[i] - a[j] + V;//枚举公差,+V是为了处理公差为负的情况

                //以 i 结尾且上一个数是 j 的公差为 diff 的等差数列数量是以 j 结尾公差为 diff 的等差数列数加一
                f[i][cp] += f[j][cp] + 1;
                f[i][cp] %= MOD;
                ans += f[j][cp] + 1;
                ans %= MOD;
            }
        }
        System.out.println(ans);
    }
}