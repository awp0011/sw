package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SolutionTreeGraph2 {
    private static final Node[] map = new Node[100_002];
    private static final ArrayDeque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= N; i++) {
                if (map[i] == null) map[i] = new Node();
                else map[i].init();
            }
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a].before.add(b);
                map[b].before.add(a);
            }

            for (int i = 1; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map[a].after.add(b);
                map[b].after.add(a);
            }
            int cnt = 0;
            for (int i = 1; i <= L; i++) {
                if (map[i].isLeaf()) cnt++;
            }
            if (cnt != L) System.out.println("#" + t + " 0");
            else {
                int cmp = 0;
                for (int i = L + 1; i <= N; i++) {
                    if (map[i].isCmp()) cmp++;
                }
                dijkstra(true, 1);
                dijkstra(false, 2);
                int ans = 1;
                for (int i = 2; i <= L; i++) {
                    if (map[i].dist2 > map[i].dist1) {
                        ans = 0;
                        break;
                    }
                    if ((map[i].dist1 - map[i].dist2) > cmp) {
                        ans = 0;
                        break;
                    }
                }
                System.out.println("#" + t + " " + ans);
            }


        }
    }

    private static void dijkstra(boolean isBefore, int visited) {
        if (isBefore) queue.addAll(map[1].before);
        else queue.addAll(map[1].after);
        map[1].visited = visited;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            for (int i : (isBefore ? map[n].before : map[n].after)) {
                if (map[i].visited == visited) continue;
                map[i].visited = visited;
                if (isBefore) map[i].dist1 += map[n].dist1 + 1;
                else map[i].dist2 += map[n].dist2 + 1;
                queue.add(i);
            }
        }

    }

    private static class Node {
        final HashSet<Integer> before = new HashSet<>();
        final HashSet<Integer> after = new HashSet<>();
        int visited, dist1, dist2;

        Node() {
            visited = 0;
            dist1 = 0;
            dist2 = 0;
        }

        boolean isLeaf() {
            return (before.size() == 1) && (after.size() == 1);
        }

        boolean isCmp() {
            return after.size() == 0;
        }

        void init() {
            before.clear();
            after.clear();
            visited = 0;
            dist1 = 0;
            dist2 = 0;
        }

    }
}
