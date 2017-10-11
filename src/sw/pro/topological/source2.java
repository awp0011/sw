package sw.pro.topological;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

class source2 {
	static int[]			indegree;
	static int[][]			map;
	static int				n, m;
	static LinkedList<Integer>	stack	= new LinkedList<>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tcArr = br.readLine().trim().split(" ");
		n = Integer.parseInt(tcArr[0]);
		m = Integer.parseInt(tcArr[1]);
		indegree = new int[n + 1];
		map = new int[m + 1][m + 1];
		int x, y;
		for (int i = 1; i <= m; i++) {
			tcArr = br.readLine().split(" ");
			x = Integer.parseInt(tcArr[0]);
			y = Integer.parseInt(tcArr[1]);
			map[x][y] = 1;
			// 入度+1
			indegree[y] += 1;
		}
		topSort1();
	}

	static void topSort1() {
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
            	stack.addFirst(i);
                indegree[i] = -1;
            }
        }
        while (!stack.isEmpty()) {
            int p = stack.removeFirst();
            System.out.print(p + " ");
            for (int j = 1; j <= n; j++) {
                if (map[p][j] == 1) {
                    map[p][j] = 0;
                    indegree[j]--;
                    if (indegree[j] == 0) {
                        stack.addFirst(j);
                        indegree[j] = -1;
                    }
                }
            }
        }
        System.out.println();
	}
}
