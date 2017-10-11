package sw.pro.point.area;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class source2 {
	static Point[]	A;
	static int		N;


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		A = new Point[N + 1];
		String[] tcArr;
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

		int i, j;
		boolean isInPinplg = false;
		for (i = 1, j = N; i <= N; j = i++) {
			if (((A[i].y > target.y) != (A[j].y > target.y))
					&& (target.x < (A[j].x - A[i].x) * (target.y - A[i].y) / (A[j].y - A[i].y) + A[i].x))
				isInPinplg = !isInPinplg;
		}
		return isInPinplg ? "in" : "out";
	}

	static class Point {
		public Point(final long a, final long b) {
			x = a;
			y = b;
		}

		long x, y;
	}
}
