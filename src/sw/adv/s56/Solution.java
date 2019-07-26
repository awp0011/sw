package sw.adv.s56;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Solution {
    private static final int[] cnt = new int[5];
    private static final int[][] BASIC = new int[25][5];
    private static final int[][] MIXED = new int[25][3];
    private static final Queue<Integer> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken());
            int M = parseInt(st.nextToken());
            q.add(parseInt(st.nextToken()));

            for (int i = 1; i <= N; i++) {
                initBasic(BASIC[i], br.readLine());
            }
            for (int i = 1; i <= M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = parseInt(st.nextToken());
                MIXED[a - N][0] = parseInt(st.nextToken());
                MIXED[a - N][1] = parseInt(st.nextToken());
            }
            while (!q.isEmpty()) {
                int n = q.poll();
                if (n > N) {
                    q.add(MIXED[n - N][0]);
                    q.add(MIXED[n - N][1]);
                } else {
                    BASIC[n][0]++;
                }
            }
            for (int i = 1; i <= N; i++) {
                cnt[1] += BASIC[i][1] * BASIC[i][0];
                cnt[2] += BASIC[i][2] * BASIC[i][0];
                cnt[3] += BASIC[i][3] * BASIC[i][0];
                cnt[4] += BASIC[i][4] * BASIC[i][0];
            }
            System.out.println("#" + t + " " + cnt[1] + " " + cnt[2] + " " + cnt[3] + " " + cnt[4]);
        }
    }

    private static void initBasic(int[] basic, String str) {
        Arrays.fill(basic, 0);
        for (char c : str.toCharArray()) {
            switch (c) {
                case 'W':
                    basic[1]++;
                    break;
                case 'E':
                    basic[2]++;
                    break;
                case 'F':
                    basic[3]++;
                default:
                    basic[4]++;
                    break;
            }
        }
    }

}
