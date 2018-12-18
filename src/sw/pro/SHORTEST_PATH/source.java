package sw.pro.SHORTEST_PATH;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class source {

    private static long INF = Long.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        City[] cities = new City[N + 1];
        for (int i = 1; i <= N; i++) {
            cities[i] = new City();
        }
        int M = parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int l = parseInt(st.nextToken());
            cities[x].roads.add(new Road(x, y, l));
            cities[y].roads.add(new Road(y, x, l));
        }

        cities[0] = new City();
        cities[0].length = 0;
        cities[0].roads.add(new Road(0, 1, 0));
        Queue<City> queue = new LinkedList<>();
        queue.add(cities[0]);
        while (!queue.isEmpty() && queue.peek() != null ) {
            City next = queue.poll();
            for (Road road : next.roads) {
                long temp = cities[road.from].length + road.length;
                if (cities[road.to].length > temp) {
                    cities[road.to].length = temp;
                    queue.add(cities[road.to]);
                }
            }
        }
        if (INF == cities[N].length) System.out.println(-1);
        else System.out.println(cities[N].length);
    }
    private static class Road {
        int from;
        int to;
        int length;

        Road(int f, int t, int l) {
            from = f;
            to = t;
            length = l;
        }

        int getLength() {
            return length;
        }
    }

    private static class City {
        boolean isVisited;
        long length;
        ArrayList<Road> roads;

        City() {
            isVisited = false;
            roads = new ArrayList<>(20);
            length = INF;
        }

        long getLength() {
            return length;
        }
    }
}
