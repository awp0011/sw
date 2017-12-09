package sw.pro.SDS_PRO_10_4;
//Kruskal算法

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class source2 {
    private static PriorityQueue<Line> queue = new PriorityQueue<>(Comparator.comparingInt(Line::getCost));
    private static int[] parents;
    private static int[] pCnt;
    private static int counter = 1;
    private static long total = 0L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
        pCnt = new int[N + 1];
        Arrays.fill(pCnt, 1);
        int M = Integer.parseInt(br.readLine());
        int s, e, c;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            queue.add(new Line(s, e, c));
        }
        br.close();

        while (counter != N) {
            Line min = queue.poll();
            if (find(min.Start) != find(min.End)) {
                //System.out.println("min--> "+min.toString());
                union(min.Start, min.End);
                total += min.getCost();
                counter++;

            }

        }
        System.out.println(total);
    }

    private static void union(final int c1, final int c2) {
        if (pCnt[parents[c1]] > pCnt[parents[c2]]) {
            parents[c2] = parents[c1];
            pCnt[parents[c1]] += pCnt[parents[c2]];
        } else {
            parents[c1] = parents[c2];
            pCnt[parents[c2]] += pCnt[parents[c1]];
        }
    }

    private static int find(final int c) {
        if (parents[c] == c) return c;
        parents[c] = find(parents[c]);
        return parents[c];
    }

    private static class Line {
        int Start, End, Cost;

        Line(final int s, final int e, final int c) {
            Start = s;
            End = e;
            Cost = c;
        }

        int getCost() {
            return Cost;
        }

        public String toString() {
            return "S:" + Start + " E:" + End + " C:" + Cost;
        }
    }

}