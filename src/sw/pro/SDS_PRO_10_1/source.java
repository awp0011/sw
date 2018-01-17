package sw.pro.SDS_PRO_10_1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class source {
    private static Node[] nodes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        nodes = new Node[V + 1];
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (nodes[x] == null) nodes[x] = new Node(x);
            if (nodes[y] == null) nodes[y] = new Node(y);
            nodes[x].subNodes_dfs.add(y);
            nodes[x].subNodes_bfs.add(y);
            nodes[y].subNodes_dfs.add(x);
            nodes[y].subNodes_bfs.add(x);
        }
        for (int i = 1; i < nodes.length; i++) {
            Collections.sort(nodes[i].subNodes_bfs);
        }
        br.close();
        bw.append(dfs(S));
        bw.newLine();
        bw.append(bfs(S));
        bw.flush();
        bw.close();
    }

    private static String bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder(10000);
        sb.append(start);
        queue.add(start);
        nodes[start].visitor = 1;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (Integer i : nodes[p].subNodes_bfs) {
                if (nodes[i].visitor != 1) {
                    sb.append(' ').append(i);
                    nodes[i].visitor = 1;
                    queue.add(i);
                }
            }
        }

        return sb.toString();
    }

    private static String dfs(int start) {
        StringBuilder sb = new StringBuilder(10000);
        Stack<Integer> stack = new Stack<>();
        stack.add(start);
        sb.append(start);
        nodes[start].visitor = -1;
        while (!stack.isEmpty()) {
            int p = stack.peek();
            if (nodes[p].subNodes_dfs.isEmpty()) {
                stack.pop();
            }
            while (!nodes[p].subNodes_dfs.isEmpty()) {
                int c = nodes[p].subNodes_dfs.poll();
                if (nodes[c].visitor != -1) {
                    stack.add(c);
                    sb.append(' ').append(c);
                    nodes[c].visitor = -1;
                    break;

                }
            }


        }
        return sb.toString();
    }


    private static class Node {
        int number;
        int visitor;
        PriorityQueue<Integer> subNodes_dfs;
        List<Integer> subNodes_bfs;

        Node(final int n) {
            number = n;
            visitor = 0;
            subNodes_dfs = new PriorityQueue<>();
            subNodes_bfs = new ArrayList<>(30);
        }
    }
}