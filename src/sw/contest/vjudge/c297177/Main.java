package sw.contest.vjudge.c297177;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final Junction[] juns = new Junction[303];
    private static final PriorityQueue<Junction> queue = new PriorityQueue<>(Comparator.comparingInt(Junction::getLen));

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int index = 1;
       do {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= n; i++) {
                if (juns[i] == null) juns[i] = new Junction(i);
                else juns[i].init();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if(c>a) continue;
                juns[u].nebr.add(new Junction(v, a, b, c));
            }
            juns[s].len = 0;
            queue.add(juns[s]);
            while (!queue.isEmpty()) {
                Junction cur = queue.poll();
                for (Junction next : cur.nebr) {

                    if (juns[next.index].len > cur.len + cur.crossTime(next)) {
                        juns[next.index].len = cur.len + cur.crossTime(next);
                        queue.add(juns[next.index]);
                    }
                }
            }
            if(juns[t].len<0) throw new Exception("a");
            System.out.printf("Case %d: %d\n", index++, juns[t].len);
        } while (br.ready());
    }

    private static class Junction {
        final int index;
        int len;
        int a, b, t;
        ArrayList<Junction> nebr;

        Junction(int i) {
            index = i;
            len = Integer.MAX_VALUE;
            nebr = new ArrayList<>();
        }

        void init() {
            len = Integer.MAX_VALUE;
            nebr.clear();
        }

        Junction(int i, int a, int b, int t) {
            index = i;
            this.a = a;
            this.b = b;
            this.t = t;
        }

        int crossTime(Junction next) {
            int left = next.a - (len % (next.a + next.b));
            return left < next.t ? left + next.b + next.t : next.t;
        }

        int getLen() {
            return len;
        }
    }
}
