package sw.luogu.stage3;

import java.io.*;
import java.util.ArrayDeque;

public class P1886 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata.in"));
        System.setOut(new PrintStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata.out"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        ArrayDeque<Node> maxQue = new ArrayDeque<>();
        ArrayDeque<Node> minQue = new ArrayDeque<>();
        ArrayDeque<Node> st = new ArrayDeque<>();
        for (int i = 0; i <= k; i++) st.addLast(new Node(i, 0));
        int next;
        StringBuilder maxStr = new StringBuilder();
        StringBuilder minStr = new StringBuilder();
        for (int i = 0; i < n; i++) {
            in.nextToken();
            next = (int) in.nval;
            if (!maxQue.isEmpty() && i - maxQue.peekFirst().idx >= k) st.add(maxQue.pollFirst());
            if (!minQue.isEmpty() && i - minQue.peekFirst().idx >= k) st.add(minQue.pollFirst());
            while (!maxQue.isEmpty() && maxQue.peekLast().val < next) st.add(maxQue.pollLast());
            while (!minQue.isEmpty() && minQue.peekLast().val > next) st.add(minQue.pollLast());
            Node aNode = st.poll();
            aNode.idx = i;
            aNode.val = next;
            maxQue.addLast(aNode);
            minQue.addLast(aNode);

            if (i >= k - 1) {
                maxStr.append(maxQue.peekFirst().val).append(' ');
                minStr.append(minQue.peekFirst().val).append(' ');
            }
        }
        System.out.println(minStr.toString());
        System.out.println(maxStr.toString());
    }

    private static class Node {
        int idx;
        int val;

        Node(final int i, final int v) {
            idx = i;
            val = v;
        }
    }
}
