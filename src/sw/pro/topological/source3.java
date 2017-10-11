package sw.pro.topological;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

class source3 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tcArr = br.readLine().split(" ");
		int V = Integer.parseInt(tcArr[0]);
		int E = Integer.parseInt(tcArr[1]);
		Edge[] edges = new Edge[V + 1];
		int[] indgree = new int[V + 1];
		boolean[] visited = new boolean[V + 1];
		for (int i = 1; i <= V; i++)
			edges[i] = new Edge(-1);

		int edgeHead, edgeTail;
		for (int i = 1; i <= E; i++) {
			tcArr = br.readLine().split(" ");
			edgeHead = Integer.parseInt(tcArr[0]);
			edgeTail = Integer.parseInt(tcArr[1]);
			Edge e = new Edge(edgeTail);
			e.next = edges[edgeHead].next;
			edges[edgeHead].next = e;

			indgree[edgeTail]++;
		}
		Queue<Integer> q = new ArrayDeque<Integer>(V);
		for (int i = 1; i <= V; i++) {
			if (indgree[i] == 0)
				q.add(i);
		}

		while (!q.isEmpty()) {
			int ver = q.poll();
			System.out.print(ver + " ");
			visited[ver] = true;
			Edge head = edges[ver] == null ? null : edges[ver].next;
			while (head != null) {
				if (--indgree[head.num] == 0)
					q.add(head.num);
				head = head.next;
			}
		}
		System.out.println();
		br.close();
	}
}

class Edge {
	Edge(int n) {
		num = n;
	}

	int		num;
	Edge	next	= null;
}