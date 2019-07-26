package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SolutionTreeGraph {
    private static final Node[] map = new Node[100_002];
    private static ArrayDeque<Node> leave = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= N; i++) {
                if (map[i] == null) map[i] = new Node(i);
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
            for (int i = 1; i <= N; i++) {
                if (map[i].isLeaf()) {
                    leave.add(map[i]);
                }
            }
            int ans = -1;
            if (leave.size() == L) {
                int cnt = 0;
                while (!leave.isEmpty()) {
                    Node n = leave.poll();
                    if (!n.before.iterator().next().equals(n.after.iterator().next())) {
                        if (map[n.before.iterator().next()].after.size() > 0) break;
                    }

                }
                if (cnt == L) ans = 1;
            }
            System.out.println("#" + t + " " + ans);

        }
    }

    private static class Node {
        final int index;
        final HashSet<Integer> before = new HashSet<>();
        final HashSet<Integer> after = new HashSet<>();

        Node(final int i) {
            index = i;
        }

        boolean isLeaf() {
            return (before.size() == 1) && (after.size() == 1);
        }

        void init() {
            before.clear();
            after.clear();
        }

    }
}
