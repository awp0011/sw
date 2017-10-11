package sw.pro.KOI_2008RH_AMEOBA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class source1 {
	static int			ADULT, BAN, DEAD, N;
	static List<Amoeba>	pool	= new ArrayList<>(100000);

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] testcase = br.readLine().split(" ");
		ADULT = Integer.parseInt(testcase[0]);
		BAN = Integer.parseInt(testcase[1]);
		DEAD = Integer.parseInt(testcase[2]);
		N = Integer.parseInt(testcase[3]);

		pool.add(new Amoeba());
		for (int i = 0; i < N; i++) {
			int cnt = pool.size();
			for (int j=0;j<cnt;j++) {
				pool.get(j).grownUp();
			}
		}
		System.out.println(pool.stream().filter(amoeba->amoeba.isAlive).count()%1000);
		br.close();
	}

	static class Amoeba {
		int		age		= 0;
		boolean	isAlive	= true;
		boolean	isNew	= true;

		void grownUp() {
			age++;
			if (age >= ADULT && age < BAN) {
				pool.add(new Amoeba());
			} else if (age >= DEAD) {
				isAlive = false;
			}

		}
	}
}
