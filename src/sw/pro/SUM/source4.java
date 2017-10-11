package sw.pro.SUM;
/*
 * 将整数m拆分为n个数字的有序拆分方案数为C(m-1,n-1)，什么意思呢？
     将ｍ分为ｍ个１，每个１中间有空隙，一共是m-1个空隙，每次选取ｎ－１空隙插入隔板，这时ｍ就给分解为n个整数。
            注意：　n个整数中不包含０
　倘若在收尾１的前后加入空隙，可以插入隔板，这时可以在ｎ个整数中选取的最多两个０
              注意：当Ｋ<=3 时，这样时正确的。
 * 本题中存在０，或者多个０的情况，所以使用C(m-1,n-1)
 * C(m-1,１)×n +C(m-1,2)×n +...+C(m-1,n-２)
 * 数字可重复
 * ２＋１　和１＋２　是两种不同的拆分方式
 * n<=40
 * */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

class source4 {
	static BigDecimal[]	tc	= new BigDecimal[201];
	static BigDecimal	MOD	= BigDecimal.valueOf(1_000_000_000);
	static int			N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		tc[0] = tc[1] = BigDecimal.ONE;
		BigDecimal Anwser = BigDecimal.valueOf(K);
		if (N == 1) {
			System.out.println(K);
		} else if (K == 1) {
			System.out.println(1);
		} else {
			if (K >= N) {
				K = N - 1;
				Anwser = Anwser.add(BigDecimal.ONE);
			}
			for (int i = 1; i < K - 1; i++) {
				Anwser = Anwser.add(factorial(N - 1).divide(factorial(i)).divide(factorial(N - 1 - i))
						.multiply(BigDecimal.valueOf(K)));
			}
			Anwser = Anwser.add(factorial(N - 1).divide(factorial(K - 1)).divide(factorial(N - K)));
			System.out.println(Anwser.divideAndRemainder(MOD)[1].longValue());
		}
	}

	static BigDecimal factorial(final int n) {
		if (tc[n] == null) {
			tc[n] = factorial(n - 1).multiply(BigDecimal.valueOf(n));
		}

		return tc[n];
	}
	

}
