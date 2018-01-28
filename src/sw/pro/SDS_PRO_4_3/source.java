package sw.pro.SDS_PRO_4_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

class source {
    private static int[] distance;
    private static LinkedList<Integer> closed = new LinkedList<>();
    private static int[] opened;
    private static int[][] map;
    private static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        opened = new int[N + 1];
        map = new int[N + 1][N + 1];
        int M = Integer.parseInt(st.nextToken());

        int T = Integer.parseInt(br.readLine());
        int xi, yi, zi;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            xi = Integer.parseInt(st.nextToken());
            yi = Integer.parseInt(st.nextToken());
            zi = Integer.parseInt(st.nextToken());
            map[xi][yi] = zi;
        }
        int begin_to_target ;
        closed.add(1);
        opened[1] = 1;
        Dijkstra(1, 1);
        if (distance[T] == 0) {
            System.out.println("NO");
        } else {
            begin_to_target = distance[T];
            System.out.println(Arrays.toString(distance));
            Arrays.fill(distance, 0);
            closed.clear();
            closed.add(T);
            opened[1] = -1;
            Dijkstra(T, -1);
            System.out.println(Arrays.toString(distance));
            if (distance[1] == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(begin_to_target + distance[1]);
            }
        }

    }

    private static void Dijkstra(final int begin, final int visitor) {
        boolean isCompleted ;
        int sumDistance;
        int next = begin;
        // System.out.println("Begin Dijkstra :");
        do {
            for (int i = 1; i <= N; i++) {
                if (i != begin && map[next][i] > 0) {
                    if (distance[i] == 0 || distance[i] > distance[next] + map[next][i]) {
                        distance[i] = distance[next] + map[next][i];
                    }
                }
            }
            sumDistance = Integer.MAX_VALUE;
            for (Integer from : closed) {
                for (int i = 1; i <= N; i++) {
                    if (map[from][i] > 0 && opened[i] != visitor) {
                        if (sumDistance == 0 || sumDistance > distance[from] + map[from][i]) {
                            sumDistance = distance[from] + map[from][i];
                            next = i;
                        }
                    }
                }
            }

            opened[next] = visitor;
            closed.add(next);
            // System.out.println(Arrays.toString(distance) + ":");
            // System.out.print(next + "-->");
            isCompleted = closed.size() == N;

        } while (!isCompleted);
        // System.out.println();
    }

}