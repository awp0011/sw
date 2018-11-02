package sw.pro.kthnumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int i = 0; i < N; i++) {
            queue.add(Integer.valueOf(br.readLine()));
        }
        //queue.forEach(i-> System.out.print(i+" "));
        while (!queue.isEmpty() && K > 1) {
            K--;
            queue.poll();
        }
        System.out.print(queue.poll());
    }
}
