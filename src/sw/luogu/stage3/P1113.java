package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class P1113 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        Node[] nodes = new Node[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = new Node();
        }
        Queue<Node> queue = new ArrayDeque<>();
        int index, parent;
        for (int i = 1; i <= N; i++) {
            in.nextToken();
            index = (int) in.nval;
            in.nextToken();
            nodes[index].len = (int) in.nval;
            in.nextToken();
            parent = (int) in.nval;
            while (parent != 0) {
                nodes[index].inDepth++;
                nodes[parent].adj.add(index);
                in.nextToken();
                parent = (int) in.nval;
            }
            if (nodes[index].inDepth == 0) {
                nodes[index].sum = nodes[index].len;
                queue.add(nodes[index]);
            }
        }
        int max = 0;
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            if (p.adj.isEmpty()) {
                max = Math.max(max, p.sum);
            } else {
                for (int c : p.adj) {
                    nodes[c].sum = Math.max(nodes[c].sum, nodes[c].len + p.sum);
                    nodes[c].inDepth--;
                    if (nodes[c].inDepth == 0) queue.add(nodes[c]);
                }
            }
        }
        System.out.println(max);
    }

    private static class Node {
        int inDepth;
        int len;
        int sum;
        final ArrayList<Integer> adj;

        Node() {
            adj = new ArrayList<>();
            sum = 0;
            inDepth = 0;
        }
    }
}
