package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.min;

public class P2279 {

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        Node[] nodes = new Node[N + 1];
        for (int i = 0; i <= N; i++) nodes[i] = new Node(i);
        nodes[1].deep = 1;
        nodes[1].prev = nodes[1];
        for (int i = 2; i <= N; i++) {
            in.nextToken();
            nodes[i].prev = nodes[(int) in.nval];
            nodes[i].deep = nodes[i].prev.deep + 1;
        }
        Arrays.sort(nodes, 1, N + 1, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.deep - o1.deep;
            }
        });
        int ans = 0;
        Node m, p, g;
        for (int i = 1; i <= N; i++) {
            m = nodes[i];
            p = m.prev;
            g = p.prev;
            m.dist = min(m.dist, min(p.dist + 1, g.dist + 2));
            if (m.dist > 2) {
                ans++;
                g.dist = 0;
                m = g;
                p = m.prev;
                g = p.prev;
                p.dist = min(1, p.dist);
                g.dist = min(2, g.dist);
            }
        }
        System.out.println(ans);
    }


    private static class Node {
        final int index;
        int deep;
        int dist;
        Node prev;

        Node(int i) {
            index = i;
            deep = 0;
            dist = 10000;
        }
    }
}
