package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayDeque;

public class P1886 {
    private static final ArrayDeque<Integer> que = new ArrayDeque<>();
    private static final int[] d = new int[1000003];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(System.out);
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;

        for (int i = 0; i < n; i++) {
            in.nextToken();
            d[i] = (int) in.nval;
        }

        for (int i = 0; i < n; i++) {
            addMinQueue(i, k);
            if (i >= k - 1 && !que.isEmpty()) {
                out.print(d[que.peekFirst()]);
                out.print(' ');
            }
        }
        que.clear();
        out.println("");
        for (int i = 0; i < n; i++) {
            addMaxQueue(i, k);
            if (i >= k - 1 && !que.isEmpty()) {
                out.print(d[que.peekFirst()]);
                out.print(' ');
            }
        }

        out.flush();
    }

    private static void addMaxQueue(int idx, int k) {
        if (!que.isEmpty() && idx - que.peekFirst() >= k) que.pollFirst();
        while (!que.isEmpty() && d[que.peekLast()] < d[idx]) que.pollLast();
        que.addLast(idx);
    }

    private static void addMinQueue(int idx, int k) {
        if (!que.isEmpty() && idx - que.peekFirst() >= k) que.pollFirst();
        while (!que.isEmpty() && d[que.peekLast()] > d[idx]) que.pollLast();
        que.addLast(idx);
    }

}
