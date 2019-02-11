package sw.TP2019.M04.P04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    private final static int MAX = 10000;
    private final static boolean[] prime = new boolean[MAX];
    private final static int[] steps = new int[MAX];
    private static int S;
    private static final ArrayDeque<Integer> q = new ArrayDeque<>();
    private final static int[] masks = new int[]{10, 100, 1000, 10000};

    public static void main(String[] args) throws IOException {
        init();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            Arrays.fill(steps, Integer.MAX_VALUE);
            steps[S] = 0;
            dfs();
            System.out.println(steps[e]);
        }
    }

    private static void nextPrime(int cur, int mask) {
        int next;
        int mod1 = cur / mask;
        int mod2;
        int offset = mask / 10;
        for (int i = 1; i <= 9; i++) {
            next = cur + (i * offset);
            mod2 = next / mask;
            if (mod2 > mod1) next -= mask;
            if (next > 9999 || next < 1000) continue;
            if (prime[next] && (steps[next] > (steps[cur] + 1))) {
                steps[next] = steps[cur] + 1;
                q.offer(next);
            }
        }
    }

    private static void dfs() {
        q.offer(S);
        while (!q.isEmpty()&&q.peek()!=null) {
            for (int mask : masks) {
                nextPrime(q.peek(), mask);
            }
            q.poll();
        }
    }


    private static void init() {
        Arrays.fill(prime, true);
        for (int i = 2; i < MAX; i++) {
            for (int j = i + 1; j < MAX; j++) {
                if (prime[j] && j % i == 0) prime[j] = false;
            }
        }
    }
}
