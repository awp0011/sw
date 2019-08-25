package sw.luogu.stage2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P1504 {
    private static ArrayDeque<Integer> queue = new ArrayDeque<>();
    private static HashSet<Integer> inQueue = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = parseInt(st.nextToken());
        int N = parseInt(st.nextToken());
        int ans = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int next = parseInt(st.nextToken());
            if (!inQueue.contains(next)) {
                ans++;
                if (inQueue.size() >= M) {
                    inQueue.remove(queue.pollFirst());
                }
                inQueue.add(next);
                queue.add(next);
            }

        }
        System.out.println(ans);
    }
}
