package sw.pro.SDS_PRO_3_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {

    //int n,m,i,num[100001],t[200001],l,r;//num:原数组；t：树状数组
    static int N;
    static int[] num;
    static long[] t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        t = new long[2 * N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = i;
            change(i, i);
        }
        int Q = Integer.parseInt(br.readLine());
        int f, x, y;
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            f = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (f == 0) {
                change(x, y);
            } else {
                System.out.println(ask(x, y));
            }
        }
    }

    static int lowbit(int x) {
        return x & (-x);
    }

    static void change(int x, int p)//将第x个数加p
    {
        int tem = p- num[x];
        num[x] = p;
        while (x <= N) {
            t[x] += tem;
            x += lowbit(x);
        }
    }

    static int sum(int k)//前k个数的和
    {
        int ans = 0;
        while (k > 0) {
            ans += t[k];
            k -= lowbit(k);
        }
        return ans;
    }

    static int ask(int l, int r)//求l-r区间和
    {
        return sum(r) - sum(l - 1);
    }
}
