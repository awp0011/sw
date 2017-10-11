package sw.pro.point.area;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {
	static Point[]	A;
	static int		N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tcArr;
		A = new Point[100_000];
		N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			tcArr = br.readLine().trim().split(" ");
			A[i] = new Point(Long.parseLong(tcArr[0]), Long.parseLong(tcArr[1]));
		}
		tcArr = br.readLine().trim().split(" ");
		Point p1 = new Point(Long.parseLong(tcArr[0]), Long.parseLong(tcArr[1]));
		tcArr = br.readLine().trim().split(" ");
		Point p2 = new Point(Long.parseLong(tcArr[0]), Long.parseLong(tcArr[1]));
		System.out.println(judge(p1));
		System.out.println(judge(p2));
		br.close();
		
	}

	static String judge(Point target) {
		if (xmulti(target, A[2], A[1]) <= 0 || xmulti(target, A[N], A[1]) >= 0) // 在第一个点为起点的扇形之外或在边上
		{
			return "out";
		}
		int left = 2, right = N;
		while (right - left != 1) {
			int mid = (left + right) / 2;
			if (xmulti(target, A[mid], A[1]) > 0)
				left = mid;
			else
				right = mid;
		}
		if (xmulti(target, A[right], A[left]) <= 0) // 在边之外或在边上
		{
			return "out";
		}
		return "in";
	}

	static long xmulti(Point p1, Point p2, Point p0) // 求p1p0和p2p0的叉积,如果大于0,则p1在p2的顺时针方向
	{
		return (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y);
	}

	static class Point {
		public Point(final long a, final long b) {
			x = a;
			y = b;
		}

		long x, y;
	}
}
