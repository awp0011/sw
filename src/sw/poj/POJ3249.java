package sw.poj;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class POJ3249 {
    private static final int MinV = Integer.MIN_VALUE >> 1;
    private static final int[] val = new int[100003];
    private static final int[] head = new int[100003];
    private static final long[] dp = new long[100003];
    private static final int[] in = new int[100003];
    private static final int[] out = new int[100003];
    private static final Edge[] edges = new Edge[1000003];
    private static final Queue<Integer> q = new ArrayDeque<Integer>();
    private static int idx;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("C:\\workspace\\idea\\sw\\src\\sw\\poj\\case.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (br.ready()) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Arrays.fill(dp, MinV);
            int N = parseInt(st.nextToken());
            int M = parseInt(st.nextToken());
            for (int i = 1; i <= N; i++) {
                val[i] = Integer.valueOf(br.readLine());
            }
            idx = 1;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                addEdge(parseInt(st.nextToken()), parseInt(st.nextToken()));
            }
            for (int i = 1; i <= N; i++)
                if (in[i] == 0) {
                    dp[i] = val[i];
                    q.add(i);
                }
            long ans = MinV;
            while (!q.isEmpty()) {
                int city = q.poll();
                if (out[city] == 0) {
                    ans = Math.max(ans, dp[city]);
                    //System.out.println(city + "-ans->" + ans);
                } else {
                    for (int i = head[city]; i != 0; i = edges[i].next) {
                        in[edges[i].to]--;
                        if (in[edges[i].to] == 0) q.add(edges[i].to);
                        dp[edges[i].to] = Math.max(dp[edges[i].to], dp[city] + val[edges[i].to]);
                        //System.out.println(city + "-top->" + edges[i].to);
                    }
                }
            }
            System.out.println(ans);


            Arrays.fill(val, 0);
            Arrays.fill(head, 0);

            Arrays.fill(in, 0);
            Arrays.fill(out, 0);
        }


    }

    private static void addEdge(int from, int to) {
        if (edges[idx] == null) edges[idx] = new Edge();
        edges[idx].next = head[from];
        edges[idx].to = to;
        edges[idx].val = val[to];
        in[to]++;
        out[from]++;
        head[from] = idx++;
    }

    private static class Edge {
        int next, to, val;

        Edge() {
        }
    }
}
