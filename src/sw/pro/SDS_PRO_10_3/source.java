package sw.pro.SDS_PRO_10_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.*;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Plant[] galaxy = new Plant[Integer.parseInt(st.nextToken()) + 1];
        for (int i = 1; i < galaxy.length; i++) {
            galaxy[i] = new Plant(i);
        }
        int pair_cnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < pair_cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int ai = Integer.parseInt(st.nextToken());
            int bi = Integer.parseInt(st.nextToken());
            long ci = Long.parseLong(st.nextToken());

            galaxy[ai].next.add(new Plant(bi, ci));

        }
        PriorityQueue<Plant> queue = new PriorityQueue<>();
        queue.add(galaxy[1]);
        while (!queue.isEmpty()) {
            Plant from = queue.poll();

            from.next.forEach(to -> {
                if (from.index == 1) {
                    galaxy[to.index].cost = to.cost;
                    queue.add(galaxy[to.index]);
                } else if (galaxy[to.index].cost > galaxy[from.index].cost + to.cost) {
                    galaxy[to.index].cost = galaxy[from.index].cost + to.cost;
                    queue.add(galaxy[to.index]);
                }
            });
        }
        if (galaxy[galaxy.length - 1].cost == Long.MAX_VALUE) System.out.println(-1);
        else System.out.println(galaxy[galaxy.length - 1].cost);
    }

    private static class Plant {
        int index;
        long cost;
        LinkedList<Plant> next;

        Plant(int i) {
            index = i;
            cost = Long.MAX_VALUE;
            next = new LinkedList<>();
        }

        Plant(int i, long c) {
            index = i;
            cost = c;
        }

        long getCost() {
            return cost;
        }
    }
}
