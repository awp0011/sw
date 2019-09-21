package sw.pro.tree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    private static final int maxN = 100003;
    private static final long[] data = new long[maxN];
    private static final long[] BIT = new long[maxN];
    private static int N, Q;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Q = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            data[i] = i;
            update(i, i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            if (c == 0) {
                int x = Integer.parseInt(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                update(x, y - data[x]);
                data[x] = y;
            } else {
                sb.append(rangeSum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    private static void update(int i, long diff) {
        while (i <= N) {
            BIT[i] += diff;
            i += (i & -i);
        }
    }

    private static long prefixSum(int i) {
        long sum = 0;
        while (i > 0) {
            sum += BIT[i];
            i -= (i & -i);
        }
        return sum;
    }

    private static long rangeSum(int from, int to) {
        return prefixSum(to) - prefixSum(from - 1);
    }
}