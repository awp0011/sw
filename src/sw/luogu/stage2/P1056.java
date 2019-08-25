package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P1056 {

    private static final PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e2[1] - e1[1]);
    private static final PriorityQueue<Integer> ret = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = parseInt(st.nextToken());
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());//row
        int L = parseInt(st.nextToken());//column
        int D = parseInt(st.nextToken());
        int[] rows = new int[M];
        int[] columns = new int[N];
        for (int i = 0; i < D; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());
            int p = parseInt(st.nextToken());
            int q = parseInt(st.nextToken());
            if (x == p) {
                int cnt = y < q ? y : q;
                columns[cnt]++;
            } else {
                int cnt = x < p ? x : p;
                rows[cnt]++;
            }
        }
        printf(rows, K);
        printf(columns, L);
    }

    private static void printf(int[] data, int top) {
        for (int i = 1; i < data.length; i++) queue.add(new int[]{i, data[i]});
        while (top > 0) {
            ret.add(queue.poll()[0]);
            top--;
        }
        while (!ret.isEmpty()) System.out.print(ret.poll() + " ");
        queue.clear();
        System.out.println();
    }
}
