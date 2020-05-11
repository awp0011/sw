package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class SolutionMergeSort {
    private static final HashMap<Integer, LinkedList<Integer>> adj = new HashMap<>();
    private static final Stack<Integer> stack = new Stack<>();
    private static final boolean[] vis = new boolean[100003];
    private static final int[] position = new int[100003];
    private static final int[] dfs = new int[100003];
    private static final int[] temp = new int[100003];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {

            in.nextToken();
            int n = (int) in.nval;
            in.nextToken();
            int start = (int) in.nval;
            int a, b;
            for (int i = 1; i < n; i++) {
                in.nextToken();
                a = (int) in.nval;
                in.nextToken();
                b = (int) in.nval;
                adj.computeIfAbsent(a, l -> new LinkedList<>()).add(b);
            }

            System.out.println("#" + t + " " + find(start));
            for (LinkedList<Integer> ll : adj.values()) ll.clear();
            Arrays.fill(position, 0);
            Arrays.fill(vis, false);
        }

    }

    private static int find(int i) {
        position[i] = 1;
        vis[i] = true;
        dfs[1] = i;
        stack.add(i);
        int ans = 0, to = 1;
        while (!stack.isEmpty()) {
            LinkedList<Integer> next = adj.get(stack.peek());
            if ( next!=null&&!next.isEmpty()) {
                int n = next.pop();
                vis[n] = true;
                stack.add(n);
                dfs[++to] = n;
                position[n] = to;
            } else {
                int pop = stack.pop();
                if (to != position[pop]) {
                    int from = position[pop] + 1;
                    mergeSort(from, to);
                    ans += -Arrays.binarySearch(dfs, from, to + 1, pop) - 1 - from;
                }
            }
        }
        return ans;
    }

    private static void mergeSort(int s, int e) {
        if (s < e) {
            int mid = (s + e) >> 1;
            mergeSort(s, mid);
            mergeSort(mid + 1, e);
            Merge(s, mid, e);
        }
    }

    private static void Merge(int s, int mid, int e) {
        int i = s;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= e) {
            if (dfs[i] <= dfs[j]) temp[k++] = dfs[i++];
            else temp[k++] = dfs[j++];
        }
        while (i <= mid) temp[k++] = dfs[i++];
        while (j <= e) temp[k++] = dfs[j++];
        if (k >= 0) System.arraycopy(temp, 0, dfs, s, k);
    }
}
