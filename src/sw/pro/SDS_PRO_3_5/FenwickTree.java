package sw.pro.SDS_PRO_3_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FenwickTree {


    private static long[] tree; //Binary Indexed Tree
    private static int[] numbs; //原始数组

    public static void main(String[] Args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        numbs = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbs[i] = i;
        }
        long sum, lowbit;
        tree = new long[numbs.length + 1];
        for (int i = 1; i < tree.length; i++) {
            sum = 0;
            lowbit = i & ((i - 1) ^ i);
            for (int j = i; j > i - lowbit; j--) {
                sum += numbs[j - 1];
            }
            tree[i] = sum;
        }
        //System.out.println(Arrays.toString(tree));
        int Q = Integer.parseInt(br.readLine());
        int f, x, y;
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            f = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if (f == 0) {
                update(x, y);
            } else {
                //System.out.println(Arrays.toString(tree));
                System.out.println(sumRange(x, y));
            }
        }
    }

    //更新
    static void update(int i, int val) {
        long tem = val - numbs[i];
        numbs[i] = val;
        i++;
        for (; i < tree.length; i = i + (i & ((i - 1) ^ i))) {
            tree[i] += tem;
        }
    }

    static long sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    //求和
    static long getSum(int i) {
        long sum = 0;
        i++;
        while (i > 0) {
            sum += tree[i];
            i = i - (i & ((i - 1) ^ i));
        }
        return sum;
    }
}

