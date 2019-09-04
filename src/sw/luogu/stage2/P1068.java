package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1068 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[][] stu = new int[n][2];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            stu[i][0] = (int) in.nval;
            in.nextToken();
            stu[i][1] = (int) in.nval;
        }
        Arrays.sort(stu, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });

        m = (int)(1.5f * m);
        if (m > n) m = n;
        int i = 0;
        StringBuilder ans = new StringBuilder();
        for (; i < n; i++) {
            if (stu[i][1] >= stu[m - 1][1]) ans.append(stu[i][0]).append(' ').append(stu[i][1]).append('\n');
            else break;
        }
        System.out.println(stu[m - 1][1] + " " + i);
        System.out.print(ans.toString());

    }
}
