package sw.luogu.stage3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class P1983 {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata.in"));
        //long start = System.currentTimeMillis();
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        Node[] nodes = new Node[N + 1];
        boolean[] vis = new boolean[N + 1];
        short[] st = new short[N + 1];
        for (int i = 1; i < N + 1; i++) nodes[i] = new Node();
        in.nextToken();
        int M = (int) in.nval;
        for (int i = 0; i < M; i++) {
            in.nextToken();
            st[0] = (short) in.nval;
            for (int j = 1; j <= st[0]; j++) {
                in.nextToken();
                st[j] = (short) in.nval;
                vis[st[j]] = true;
            }
            for (int j = st[1]; j <= st[st[0]]; j++) {
                if (vis[j]) continue;
                if(nodes[j].adj==null)nodes[j].adj = new BitSet();
                for (int k = 1; k <= st[0]; k++) {
                    if (!nodes[j].adj.get(st[k])) {
                        nodes[st[k]].inDept++;
                        nodes[j].adj.set(st[k]);
                    }
                }
            }
            Arrays.fill(vis, false);
        }
        ArrayDeque<Node> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) if (nodes[i].inDept == 0) deque.add(nodes[i]);
        while (!deque.isEmpty()) {
            Node cur = deque.poll();
            if(cur.adj==null) continue;
            int i =cur.adj.nextSetBit(0);
           while(i>=0){
                if (--nodes[i].inDept == 0) {
                    deque.add(nodes[i]);
                    if (cur.level + 1 > nodes[i].level) nodes[i].level = (short) (cur.level + 1);
                }
               i =cur.adj.nextSetBit(i+1);
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) ans = Math.max(ans, nodes[i].level);
        System.out.println(ans);
    }

    private static class Node {
        short level;
        short inDept = 0;
        BitSet adj;
        Node() {
            level = 1;
        }
    }
}
