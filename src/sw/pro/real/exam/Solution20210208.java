package sw.pro.real.exam;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Solution20210208 {
    private static final int MOD = 1_000_000_007;
    private static final long[][] combin = new long[102][102];
    private static final HashMap<Integer, Integer> map = new HashMap<>();
    private static final int[] d = new int[102];
    private static final int[] tmp = new int[102];
    private static final int[] cnt = new int[102];
    private static final LinkedList<Integer> queue = new LinkedList<>();
    private static int N, K;
    private static long ANS;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream(""));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = parseInt(st.nextToken());
            K = parseInt(st.nextToken());
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            for (int i = 1; i <= 2; i++) {
                d[i] = parseInt(st2.nextToken());
                map.put(d[i], i);
                queue.add(i);
                cnt[i] = 1;
            }
            for (int i = 1; i <= K; i++) {
                tmp[i] = parseInt(st1.nextToken());
            }
            Arrays.sort(tmp, 1, K + 1);
            int idx = 3;
            for (int i = 1; i <= K; i++) {
                if (tmp[i] != d[1] && tmp[i] != d[2]) {
                    d[idx] = tmp[i];
                    map.put(d[idx], idx);
                    idx++;
                }
            }
            ANS = 0;
            int len1 = d[1] + d[2], len2 = d[1] + d[2];
            while (len1 < N) {
                while (len2 < N) {
                    dfs(3, len2);
                    cnt[2]++;
                    len2 = cnt[1] * d[1] + cnt[2] * d[2];
                }
                cnt[1]++;
                cnt[2] = 1;
                len1 = cnt[1] * d[1] + d[2];
            }

            System.out.println("#" + tc + " " + ANS);
            map.clear();
            queue.clear();
            Arrays.fill(d, 0);
            Arrays.fill(cnt, 0);
        }
    }

    //计算N 由K中的组合情况
    private static void dfs(int i, int sum) {
        if (sum < N) {
            //  继续递归 求N的组成
            for (int j = i; j <= K; j++) {
                cnt[i] = 1;
                int tmp = cnt[i] * d[i] + sum;
                if (tmp > N) break;
                queue.add(i);
                while (tmp <= N) {
                    dfs(i + 1, tmp);
                    cnt[i]++;
                    tmp = cnt[i] * d[i] + sum;
                }
                queue.pollLast();
            }
        } else {
            //  sum == N  计算此时 组合数
            Iterator<Integer> it = queue.iterator();
            long sum1 = 1;
            int n = cnt[it.next()];
            while (it.hasNext()) {
                long sum2 = 0;
                int m = cnt[it.next()];
                for (int j = 1; j <= m; j++) {
                    sum2 += C(j, n + 1);
                    sum2 %= MOD;
                }
                n += m;
                sum1 *= sum2;
                sum1 %= MOD;
            }
            ANS += sum1;
            ANS %= MOD;
        }

    }

    //计算组合数
    private static long C(int m, int n) {
        if (combin[m][n] > 0) return combin[m][n];
        if (m == 1) return combin[m][n] = n;
        if (n == m) return combin[m][n] = 1;
        combin[m][n] = combin[m - 1][n - 1] + combin[m][n - 1];
        return combin[m][n] %= MOD;
    }

}
