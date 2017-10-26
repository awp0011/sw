package sw.pro.SDS_PRO_4_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class source3 {
	static int[]				glass	= new int[1001];
	
	static LinkedList<Field>	queue	= new LinkedList<>();

	public static void main(String[] args) throws Exception {

		int[] cow = new int[101];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Field[]				fields	= new Field[N+1];
		for (int i = 1; i <= K; i++) {
			cow[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= N; i++) {
			fields[i] = new Field(i);
		}
		int p, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			fields[p].chilren_cnt++;
			fields[p].visit.add(fields[c]);
			fields[c].parents.add(fields[p]);

		}

		// Arrays.stream(fields).filter(f -> f.chilren_cnt == 0).forEach(f ->
		// queue.add(f));

		for (int i = 1; i <= N; i++) {
			if (fields[i].chilren_cnt == 0) {
				queue.add(fields[i]);
			}
		}

		bfs();
		Field field = null;
		for (int i = 1; i <= K; i++) {
			while (fields[cow[i]].visit.size() != 0) {
				field = fields[cow[i]].visit.pop();
				if (glass[field.index] == i - 1)
					glass[field.index] = i;
			}

		}
		/*for (Field f : fields) {
			if(f==null) continue;
			System.out.print("index:" + f.index + "  visit:");
			while (f.visit.size() != 0) {
				System.out.print("->" + f.visit.poll().index);
			}
			System.out.println();

		}*/
		
		for (int i = 1; i <= K; i++) {
			if (glass[cow[i]] == i - 1)
				glass[cow[i]] = i;
			
			while (fields[cow[i]].visit.size() != 0) {
				field = fields[cow[i]].visit.pop();
				if (glass[field.index] == i - 1)
					glass[field.index] = i;
			}

			System.out.println(Arrays.toString(Arrays.copyOf(glass, N + 1)));
		}
		System.out.println(Arrays.stream(glass).filter(i -> i == K).count());
	}

	static void bfs() {
		while (queue.size() != 0) {
			searchVisitField(queue.pop());
		}
		
	}

	static void searchVisitField(Field field) {
		Field parent = null;
		while (field.parents.size() != 0) {
			parent = field.parents.pop();
			parent.visit.removeAll(field.visit);
			parent.visit.addAll(field.visit);
			parent.chilren_cnt--;
			if (parent.chilren_cnt == 0) {
				queue.add(parent);
			}
		}
	}

	static class Field {
		int					index;
		int					chilren_cnt	= 0;
		LinkedList<Field>	parents		= new LinkedList<>();
		LinkedList<Field>	visit		= new LinkedList<>();

		Field(int i) {
			index = i;
		}
	}
}