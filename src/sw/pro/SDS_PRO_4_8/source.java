package sw.pro.SDS_PRO_4_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * dfs+lca
 *
 * */
public class source {
	static Stack<City>			stack		= new Stack<>();
	static City[]				cities;
	static int					N;

	static Map<String, Integer>	ancestors	= new HashMap<String, Integer>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cities = new City[N + 1];
		for (int i = 0; i <= N; i++) {
			cities[i] = new City(i);
		}
		int one, another;
		StringTokenizer st = null;
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			one = Integer.parseInt(st.nextToken());
			another = Integer.parseInt(st.nextToken());
			cities[one].dest.add(cities[another]);
			cities[another].dest.add(cities[one]);
		}
		stack.push(cities[1]);
		cities[1].parent = 1;
		dfs();
		Integer lca, sumLength = 0;
		String calculetedkey = "";
		for (City c : cities) {
			lca = ancestors.get(c.toNextKey);
			if (lca != null) {
				calculetedkey = c.name + "-" + lca.intValue() + "-len";
				sumLength += ancestors.containsKey(calculetedkey) ? ancestors.get(calculetedkey).intValue()
						: calculate(c.name, lca.intValue());
				calculetedkey = c.nextCity + "-" + lca.intValue() + "-len";
				sumLength += ancestors.containsKey(calculetedkey) ? ancestors.get(calculetedkey).intValue()
						: calculate(c.nextCity, lca.intValue());
			}
		}
		System.out.println(sumLength);
	}

	static void dfs() {
		while (!stack.isEmpty()) {
			if (stack.peek().dest.isEmpty()) {
				City current = stack.pop();
				// System.out.print("pop-->"+current.name);
				if (current.nextCity <= N && cities[current.nextCity].isVisited) {
					if (!ancestors.containsKey(current.toNextKey)) {
						ancestors.put(current.toNextKey, findLCA(current.nextCity));
					}
				}
				if (current.prevCity > 0 && cities[current.prevCity].isVisited) {
					if (!ancestors.containsKey(current.fromPrevKey)) {
						ancestors.put(current.fromPrevKey, findLCA(current.prevCity));
					}
					// cities[current.prevCity].parent = findLCA(current.prevCity);
					// System.out.print(", prevCity lca:"+cities[current.prevCity].parent);
				}
				current.isVisited = true;
				// System.out.println(", "+current.name+" visited");
				current.parent = stack.isEmpty() ? 1 : stack.peek().name;
				// System.out.println(",current parent:"+current.parent);
			} else {
				// System.out.println("peek()-->"+stack.peek().name);
				City next = stack.peek().dest.pop();
				if (!stack.contains(next)) {
					// System.out.println("get next-->"+next.name+",parent:"+stack.peek().name);
					// next.parent = stack.peek().name;
					stack.push(next);
				}

			}
		}
	}

	static int findLCA(int name) {
		int cur = name;
		int len = 0;
		while (cities[cur].parent != cur) {
			cur = cities[cur].parent;
			len++;
		}
		ancestors.put(name + "-" + cur + "-len", len);
		return cur;
	}

	static int calculate(int me, int ancestor) {
		int cur = me;
		int len = 0;
		while (cities[cur].name != ancestor) {
			cur = cities[cur].parent;
			len++;
		}
		return len;
	}

	static class City {
		int					name;
		int					parent;
		int					deepth;
		int					nextCity;
		String				toNextKey;
		int					prevCity;
		String				fromPrevKey;
		boolean				isVisited;
		LinkedList<City>	dest;

		City(int n) {
			name = n;
			deepth = n;
			parent = n;
			nextCity = n + 1;
			toNextKey = name + "-" + nextCity + "lca";
			prevCity = n - 1;
			fromPrevKey = prevCity + "-" + name + "lca";
			dest = new LinkedList<>();
		}

		public boolean equals(City o) {
			if (o == null)
				return false;
			return o.name == this.name;
		}
	}
}