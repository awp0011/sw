package sw.pro.SDS_PRO_4_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class source {
	public static void main(String[] args) throws Exception {

		Stack<Integer> stackA = new Stack<>();
		Stack<Integer> stackB = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] parent = new int[N + 3];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		int p, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			parent[c] = p;
		}
		stackA.push(A);
		while (parent[stackA.peek()] != 0) {
			stackA.push(parent[stackA.peek()]);
		}
		stackB.push(B);
		while (parent[stackB.peek()] != 0) {
			stackB.push(parent[stackB.peek()]);
		}

		if (stackA.peek().intValue() != stackB.peek().intValue()) {
			System.out.println("-1");
		} else {
			while (!stackA.isEmpty() && !stackB.isEmpty() && stackA.peek().intValue() == stackB.peek().intValue()) {
				stackA.pop();
				stackB.pop();
			}
			System.out.println(stackA.size() + stackB.size());
		}

	}
}