package sw.pro.SUM;

/*
 * 将整数m拆分为n个数字的有序拆分方案数为C(n-1，m-1)，什么意思呢？
     将ｍ分为ｍ个１，每个１中间有空隙，一共是m-1个空隙，每次选取ｎ－１空隙插入隔板，这时ｍ就给分解为n个整数。
            注意：　n个整数中不包含０
     倘若，n个数中包含0 和m 则一共是m+1个空隙，n-1个隔板     
   所以结果是： C(n-1，m+1)
   直接计算：(m+1)! / ((n-1)!*(m+1-n+1)!)
   递推公式：c(n,m)=c(n-1,m-1)+c(n,m-1)   m个数中取n个数
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class source3 {
	static int[]	tc	= new int[201];
	static int		MOD	= 1_000_000_000;
	static int		N, K, aswner;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if (N == 1 || K == 1) {
			System.out.println(1);
		} else {
			if (K >= N) {
				K = N;
			}
			int middle = 0;
			for (int i = 0; i < K - 1; i++) {
				middle = combination(i, N - 1);
				System.out.print("-->" + middle);
				aswner += K * middle;
			}
			middle = combination(K - 1, N - 1);
			System.out.println("-->" + middle);
			aswner += middle;

			System.out.println(aswner);
		}
	}

	static int combination(final int n, final int m) {
		if (n == 1)
			return m;
		if (n == m || n == 0)
			return 1;
		return combination(n - 1, m - 1) + combination(n, m - 1);
	}
	// c(n,m)=c(n-1,m-1)+c(n-1,m) 从n个元素中选取m个元素
	static int permutation(final int n,final int m) {
		return 0;
	}
}
