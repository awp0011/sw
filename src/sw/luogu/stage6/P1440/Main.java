package sw.luogu.stage6.P1440;

import java.io.*;
import java.util.ArrayDeque;

public class Main {
    private static StreamTokenizer in;
    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int N = nextInt();
        int M = nextInt();
        int[] d = new int[2];
        d[0] = 1;
        d[1] = nextInt();
        queue.add(d.clone());
        out.println(0);
        for (int i = 2; i <= N; i++) {
            d[0] = i;
            d[1] = nextInt();
            while (!queue.isEmpty() && (queue.peekFirst()[0] + M) < i) queue.pollFirst();
            if (!queue.isEmpty()) out.println(queue.peekFirst()[1]);
            while (!queue.isEmpty() && queue.peekLast()[1] > d[1]) queue.pollLast();
            queue.addLast(d.clone());
        }
        out.flush();
    }
}
