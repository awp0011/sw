package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.LinkedList;

public class SolutionPath {
    private static final HashMap<Integer, LinkedList<Integer>> adj = new HashMap<>();
    private static final LinkedList<Integer> stack = new LinkedList<>();
    private static final Node[] nodes = new Node[100001];
    private static int start;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            in.nextToken();
            int n = (int) in.nval;
            in.nextToken();
            start = (int) in.nval;
            for (int i = 0; i <= n; i++) {
                if (nodes[i] == null) nodes[i] = new Node(i);
                else nodes[i].init();
            }
            for (int i = 1; i < n; i++) {
                in.nextToken();
                int a = (int) in.nval;
                in.nextToken();
                int b = (int) in.nval;
                adj.computeIfAbsent(a, l -> new LinkedList<>()).add(b);
            }
            System.out.println("#" + t + " " + dfs());
        }
    }

    private static int dfs() {
        stack.add(start);
        int sum = 0;
        while (!stack.isEmpty()) {
            LinkedList<Integer> next = adj.get(stack.peekLast());
            if (next == null || next.isEmpty()) {
                remove(stack.pollLast());
            } else {
                int in = next.poll();
                stack.add(in);
                sum += add(in);
            }
        }
        return sum;
    }

    private static int add(int i) {//add to binary search tree
        int next = start;
        while (next != -1) {
            if (i > next) {
                nodes[next].rightCnt++;
                 if (nodes[next].rightChild == -1) {
                    nodes[next].rightChild = i;
                    nodes[i].parent = next;
                    next = -1;
                } else {
                    next = nodes[next].rightChild;
                }
            } else {
                nodes[i].cnt += nodes[next].rightCnt + 1;
                if (nodes[next].leftChild == -1) {
                    nodes[next].leftChild = i;
                    nodes[i].parent = next;
                    nodes[i].isLeft = true;
                    next = -1;
                } else {
                    next = nodes[next].leftChild;
                }
            }
        }
        return nodes[i].cnt;
    }

    private static void remove(int i) {
        if (nodes[i].isLeft) {
            nodes[nodes[i].parent].leftChild = -1;
        } else {
            nodes[nodes[i].parent].rightChild = -1;
            nodes[nodes[i].parent].rightCnt--;
        }
        int pre = nodes[i].parent;
        while (pre != start) {
            if (!nodes[pre].isLeft) {
                nodes[nodes[pre].parent].rightCnt--;
            }
            pre = nodes[pre].parent;
        }
    }

    private static class Node {
        int parent;
        int cnt;
        int leftChild;
        int rightChild;
        int rightCnt;
        boolean isLeft;

        final int idx;

        Node(int i) {
            idx = i;
            init();
        }

        void init() {
            isLeft = false;
            cnt = 0;
            parent = idx;
            leftChild = -1;
            rightChild = -1;
            rightCnt = 0;
        }
    }
}
