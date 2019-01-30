package sw.TP2019.M03.P06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = parseInt(st.nextToken());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        int[] cows = new int[K];
        for (int i = 0; i < K; i++) {
            cows[i] = parseInt(br.readLine());
        }

        Field[] glasses = new Field[N + 1];
        for (int i = 0; i <= N; i++) {
            glasses[i] = new Field(i);
        }
        glasses[0].cnt = 0 - K;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = parseInt(st.nextToken());
            int to = parseInt(st.nextToken());
            glasses[from].addTo(to);
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < K; i++) {
            queue.offer(cows[i]);
            glasses[cows[i]].visitor = i;
            glasses[cows[i]].cnt++;
            int current;
            while (queue.peek() != null && !queue.isEmpty()) {
                current = queue.poll();
                for (int next : glasses[current].to) {
                    if (glasses[next].visitor != i) {
                        glasses[next].visitor = i;
                        glasses[next].cnt++;
                        queue.offer(next);
                    }
                }

            }

        }
        int ans = 0;
        for (Field f : glasses) {
            if (f.cnt == K) ans++;
        }
        System.out.println(ans);

    }

    private static class Field {
        int from;
        ArrayList<Integer> to;
        int visitor;
        int cnt;

        Field(int f) {
            from = f;
            to = new ArrayList<>(20);
            visitor = -1;
            cnt = 0;
        }

        void addTo(int t) {
            to.add(t);
        }
    }
}