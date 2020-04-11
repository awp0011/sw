package sw.luogu.stage4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class P2196 {
    private static final Queue<Node> pq = new LinkedList<>();
    private static final HashSet<Integer> ret = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        Node[] nodes = new Node[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) nodes[i] = new Node(i, parseInt(st.nextToken()));
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = i + 1; j <= n; j++) {
                if (1 == parseInt(st.nextToken())) nodes[i].next.add(j);
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            pq.add(nodes[i]);
            nodes[i].path.add(i);
            nodes[i].sum = nodes[i].val;
            while (!pq.isEmpty()) {
                Node d = pq.poll();
                for (int p : d.next) {
                    if (d.sum + nodes[p].val > nodes[p].sum) {
                        nodes[p].sum = d.sum + nodes[p].val;
                        nodes[p].path.clear();
                        nodes[p].path.addAll(d.path);
                        nodes[p].path.add(p);
                        pq.add(nodes[p]);
                    }
                }
            }
            for (int j = 1; j <= n; j++) {
                if (nodes[j].sum > max) {
                    max = nodes[j].sum;
                    ret.clear();
                    ret.addAll(nodes[j].path);
                }

            }
        }


        for (int i : ret) {
            System.out.print(i);
            System.out.print(' ');
        }
        System.out.println();
        System.out.println(max);
    }

    private static class Node {
        int idx;
        int val;
        int sum;
        ArrayList<Integer> next;
        HashSet<Integer> path;


        Node(int i, int v) {
            idx = i;
            val = v;
            sum = 0;
            next = new ArrayList<>();
            path = new HashSet<>();
            //path.add(idx);
        }
    }
}
