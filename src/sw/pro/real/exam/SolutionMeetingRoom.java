package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class SolutionMeetingRoom {
    /*
   0:start
   1:end
   2:next meeting
   3:last time
   4:isUsed
     */

    private static final int[][] meetings = new int[3003][4];
    private static final long[] val = new long[3003];
    private static final boolean[] vis = new boolean[3003];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            in.nextToken();
            int n = (int) in.nval;
            for (int i = 1; i <= n; i++) {
                in.nextToken();
                meetings[i][0] = (int) in.nval;
                in.nextToken();
                meetings[i][1] = (int) in.nval;
                in.nextToken();
                val[i] = (long) in.nval;
                meetings[i][2] = i;
                meetings[i][3] = meetings[i][1];
                vis[i] = false;
            }
            Arrays.sort(meetings, 1, n + 1, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            for (int i = 2; i <= n; i++) {
                for (int j = i - 1; j >= 1; j--) {

                }
            }
        }
    }

}
