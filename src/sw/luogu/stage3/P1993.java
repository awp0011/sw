package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class P1993 {
    private static Node[] nodes;

    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata (2).in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        nodes = new Node[N + 1];
        for (int i = 0; i <= N; i++) nodes[i] = new Node();
        in.nextToken();
        int M = (int) in.nval;
        int t, a, b, c;
        for (int i = 0; i < M; i++) {
            in.nextToken();
            t = (int) in.nval;
            in.nextToken();
            a = (int) in.nval;
            in.nextToken();
            b = (int) in.nval;
            if (t == 1) {
                in.nextToken();
                c = (int) in.nval;
                nodes[a].adj.add(new int[]{b, -c});
            } else if (t == 2) {
                in.nextToken();
                c = (int) in.nval;
                nodes[b].adj.add(new int[]{a, c});
            } else {
                nodes[a].adj.add(new int[]{b, 0});
                nodes[b].adj.add(new int[]{a, 0});
            }
        }
        boolean ans = false;
        for (int i = 1; i <= N; i++) {
            nodes[i].c = 0;
            ans = spfa(i);
            if (ans) break;
        }
        System.out.println(ans ? "No" : "Yes");
    }

    private static boolean spfa(int i) {
        nodes[i].vis = true;
        for (int[] next : nodes[i].adj) {
            if (nodes[next[0]].c > nodes[i].c + next[1]) {
                if (nodes[next[0]].vis) {
                    return true;
                } else {
                    nodes[next[0]].c = nodes[i].c + next[1];
                    if (spfa(next[0])) return true;
                }
            }
        }
        nodes[i].vis = false;
        return false;
    }

    private static class Node {
        int c;
        boolean vis;
        final ArrayList<int[]> adj;

        Node() {
            c = 0;
            vis = false;
            adj = new ArrayList<>();
        }
    }
}
