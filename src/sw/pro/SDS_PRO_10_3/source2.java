package sw.pro.SDS_PRO_10_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class source2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Plant[] galaxy = new Plant[N + 1];
        for (int i = 1; i < galaxy.length; i++) {
            galaxy[i] = new Plant(i);
        }
        int pair_cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < pair_cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());
            int ci = Integer.parseInt(st.nextToken());
            galaxy[ai].next.add(new int[]{ai, bi, ci});
        }
        br.close();

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Plant> queue = new PriorityQueue<>(Comparator.comparing(Plant::getCost));
        queue.add(galaxy[1]);
        galaxy[1].cost = 0;
        int cnt = 0, to = 1, cost = 2;
        while (!queue.isEmpty() && (cnt != N) ) {
            Plant move = queue.poll();
            if (!visited[move.index]) {
                cnt++;
                for (int[] p : galaxy[move.index].next) {
                    int c = move.cost + p[cost];
                    queue.add(new Plant(p[to], c));
                    if (galaxy[p[to]].cost > c) galaxy[p[to]].cost = c;

                }
            }
            visited[move.index] = true;
        }
        if (visited[N]) System.out.println(galaxy[N].cost);
        else System.out.println(-1);

    }

    private static class Plant {
        int index;
        int cost;
        LinkedList<int[]> next;

        Plant(int i) {
            index = i;
            cost = Integer.MAX_VALUE;
            next = new LinkedList<>();
        }

        Plant(int i, int c) {
            index = i;
            cost = c;
        }

        int getCost() {
            return cost;
        }
    }
}
