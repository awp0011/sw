package sw.TP2019.M04.P05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class source {
    private final static int MAX = 5842;
    private final static long[] R = new long[MAX + 5];
    private final static int[] p = new int[]{2, 3, 5, 7};


    public static void main(String[] args) throws IOException {
        init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            System.out.println(R[Integer.parseInt(br.readLine())]);
        }
    }

    public static void init() {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int index = 1;
        while (!queue.isEmpty() && index <= MAX) {
            long cur = queue.poll();
            R[index++] = cur;
            for (int i : p) {
                long next = i * cur;
                if (queue.contains(next)) continue;
                queue.offer(next);
            }
        }
    }
}
