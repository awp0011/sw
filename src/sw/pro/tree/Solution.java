package sw.pro.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static final int[] bitArr = new int[100_005];

    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int Q = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            int j = i + (i & -i);
            if (j < N) bitArr[j] += i;
        }
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if (c == 0) {
                update(x, y);
            } else {
                sb.append(rangeSum(x, y)).append('\n');
            }
        }
        System.out.println(sb.toString());
    }

    private static void update(int pos, int val) {
        pos += 1;
        while (pos < N) {
            bitArr[pos] += val;
            pos = pos + (pos & -pos);
        }
    }

    private static int prefixSum(int pos) {
        pos += 1;
        int sum = 0;
        while (pos > 0) {
            sum += bitArr[pos];
            pos = pos - (pos & -pos);
        }
        return sum;
    }

    private static int rangeSum(int from, int to) {
        return prefixSum(to) - prefixSum(from-1);
    }
}
