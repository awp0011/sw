package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1339 {

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        in.nextToken();
        int C = (int) in.nval;
        in.nextToken();
        int Ts = (int) in.nval;
        in.nextToken();
        int Te = (int) in.nval;


        Node[] nodes = new Node[T + 1];
        int Rs, Re, Ci;
        for (int i = 0; i < C; i++) {
            in.nextToken();
            Rs = (int) in.nval;
            in.nextToken();
            Re = (int) in.nval;
            in.nextToken();
            Ci = (int) in.nval;

            if (nodes[Rs] == null) nodes[Rs] = new Node();
            if (nodes[Rs].adj == null) nodes[Rs].adj = new ArrayList<>();
            nodes[Rs].adj.add(new int[]{Re, Ci});
            if (nodes[Re] == null) nodes[Re] = new Node();
            if (nodes[Re].adj == null) nodes[Re].adj = new ArrayList<>();
            nodes[Re].adj.add(new int[]{Rs, Ci});
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.fee - o2.fee;
            }
        });
        pq.add(nodes[Ts]);
        nodes[Ts].vis = true;
        nodes[Ts].fee = 0;
        while (!pq.isEmpty()) {
            Node u = pq.poll();
            if (!u.vis) continue;
            if (u.adj == null) continue;
            for (int[] offset : u.adj) {
                int tmpFee = u.fee + offset[1];
                if (nodes[offset[0]].fee > tmpFee) {
                    nodes[offset[0]].fee = tmpFee;
                    pq.add(nodes[offset[0]]);
                    nodes[offset[0]].vis = true;
                }

            }
            nodes[Ts].vis = false;
        }
        System.out.println(nodes[Te].fee);
    }

    private static class Node {
        int fee;
        boolean vis;
        ArrayList<int[]> adj;

        Node() {
            fee = Integer.MAX_VALUE >> 1;
            vis = false;
        }
    }
}
