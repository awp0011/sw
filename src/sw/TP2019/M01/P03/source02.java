package sw.TP2019.M01.P03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class source02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>(1000);
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        int index = K;
        StringBuilder sb = new StringBuilder(2000);
        while (!queue.isEmpty()) {
            Integer i = queue.poll();
            if (index == K) {
                sb.append(i).append(' ');
                index = 1;
            } else {
                queue.offer(i);
                index++;
            }
        }
        System.out.println(sb.toString());
    }
}
