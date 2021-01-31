package sw.pro.a6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Solution {
    private static int[] minTree = new int[300003];
    private static int[] maxTree = new int[300003];
    private static long minSum, maxSum;
    private static int offset;
    private static int[] temp = new int[2];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int tc = 1; tc <= T; tc++) {
            minSum = 0;
            maxSum = 0;

            in.nextToken();
            int N = (int) in.nval;
            in.nextToken();
            int Q = (int) in.nval;

            offset = 1;

            while (offset <= N) offset <<= 1;
            for (int i = 0; i < N; i++) {
                in.nextToken();
                minTree[offset + i] = maxTree[offset + i] = (int) in.nval;
            }
            initTree();
            for (int i = 0; i < Q; i++) {
                in.nextToken();
                int cmd = (int) in.nval;
                in.nextToken();
                int a = (int) in.nval;
                in.nextToken();
                int b = (int) in.nval;

                if (cmd == 1) {
                    update(a, b);
                } else {
                    query(a, b);
                    maxSum += temp[0];
                    minSum += temp[1];
                }
            }
            System.out.println("#" + tc + " " + maxSum + " " + minSum);
        }
    }

    private static void initTree() {
        int idx = offset - 1;
        while (idx > 0) {
            maxTree[idx] = Integer.max(maxTree[idx * 2], maxTree[idx * 2 + 1]);
            minTree[idx] = Integer.min(minTree[idx * 2], minTree[idx * 2 + 1]);
            idx--;
        }
    }

    private static void update(int pos, int val) {
        int idx = offset + pos - 1;
        maxTree[idx] = val;
        minTree[idx] = val;
        while (idx > 0) {
            idx >>= 1;
            maxTree[idx] = Integer.max(maxTree[idx], val);
            minTree[idx] = Integer.min(minTree[idx], val);
        }
    }

    private static void query(int a, int b) {
        temp[0] = 0;//max
        temp[1] = 10000;//min

        int l = offset + a - 1;
        int r = offset + b - 1;

        while (l <= r) {
            if (l % 2 == 1) {
                temp[0] = Integer.max(maxTree[l], temp[0]);
                temp[1] = Integer.min(minTree[l], temp[1]);
            }
            if (r % 2 == 0) {
                temp[0] = Integer.max(maxTree[r], temp[0]);
                temp[1] = Integer.min(minTree[r], temp[1]);
            }
            l = (l + 1) >> 1;
            r = (r - 1) >> 1;
        }
    }
}
