package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Solution20191217 {
    private static final ArrayDeque<int[]> queue = new ArrayDeque<>();
    private static final int[] ri = new int[100001];
    private static final int[] Q = new int[100001];
    private static final int[] Z = new int[100001];
    private static int n;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("E:\\eclipse-workspace\\SW.PRO\\tc\\simple20191205-1.in"));
        long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) Q[i] = parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                Z[i] = parseInt(st.nextToken());
                ri[Z[i]] = i;
            }
            queue.clear();
            System.out.println("#" + t + " " + (match() ? "Impossible" : "Possible"));
            n++;
            Arrays.fill(ri, 0, n, 0);
            Arrays.fill(Q, 0, n, 0);
            Arrays.fill(Z, 0, n, 0);
        }
    }

    private static boolean match() {
        boolean flag = true;
        int pVal, zPos;
        queue.add(new int[]{1, n});
        while (!queue.isEmpty() && flag) {
            int[] pos = queue.poll();
            pVal = Q[pos[0]];
            zPos = ri[pVal];
            if (pos[1] - pos[0] <= 3) {

            } else {

            }


        }
        return flag;
    }
}
