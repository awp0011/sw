
package sw.pro.SUM;

/*
 * 将整数m拆分为n个数字的有序拆分方案数为C(n-1，m-1)，什么意思呢？
     将ｍ分为ｍ个１，每个１中间有空隙，一共是m-1个空隙，每次选取ｎ－１空隙插入隔板，这时ｍ就给分解为n个整数。
            注意：　n个整数中不包含０
     倘若，n个数中包含0 和m 则一共是m+1个空隙，n-1个隔板     
   所以结果是： C(n-1，m+1)
   直接计算：(m+1)! / ((n-1)!*(m+1-n+1)!)
   递推公式：c(n,m)=c(n-1,m-1)+c(n,m-1)   m个数中取n个数
   (20,4) = C(4,0)*C(19, 3) + C(4,3)*C(19, 2) + C(4,2)*C(19, 1) + C(4,1)*C(19, 0)
    20拆分为4个整数的总数量= 20拆分为4个不为零的整数的个数
                                     +20拆分为3个不为零的整数的个数×补足零后组合
                                     +20拆分为2个不为零的整数的个数×补足零后组合
                                     +20拆分为4个不为零的整数的个数×补足零后组合
    if N < K ,
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Combination {
    static long[][] C_Data = new long[201][201];
    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long answer = 0;

        if (N == 1 || K == 1) {
            System.out.println(1);
        } else {
            int end = K > N ? N : K;
//			if (K >= N) {
//				K = N;
//			}
            for (int i = 0; i < end; i++) {
                answer += combination(i, N - 1) * combination(i + 1, K);
                answer %= MOD;
            }

            System.out.println(answer);
        }
    }

    // c(n,m)=c(n-1,m-1)+c(n-1,m) 从n个元素中选取m个元素
    static long combination(final int n, final int m) {
        if (C_Data[n][m] != 0)
            return C_Data[n][m];

        if (n == 1) {
            C_Data[n][m] = m;
            return C_Data[n][m];
        }
        if (n == m || n == 0) {
            C_Data[n][m] = 1;
            return C_Data[n][m];
        }
        C_Data[n - 1][m - 1] = combination(n - 1, m - 1) % MOD;
        C_Data[n][m - 1] = combination(n, m - 1) % MOD;
        C_Data[n][m] = C_Data[n - 1][m - 1] + C_Data[n][m - 1];
        C_Data[n][m] %= MOD;
        return C_Data[n][m];
    }

}
