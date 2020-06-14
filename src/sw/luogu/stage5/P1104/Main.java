package sw.luogu.stage5.P1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        String[] names = new String[n + 2];
        int[][] d = new int[n + 2][4];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            names[i] = in.sval;
            in.nextToken();
            d[i][1] = (int) in.nval;
            in.nextToken();
            d[i][2] = (int) in.nval;
            in.nextToken();
            d[i][3] = (int) in.nval;

            d[i][0] = i;
        }
        Arrays.sort(d, 1, n + 1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) return o1[1] - o2[1];
                if (o1[2] != o2[2]) return o1[2] - o2[2];
                if (o1[3] != o2[3]) return o1[3] - o2[3];
                return o2[0]-o1[0];
            }
        });
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <=n ; i++) {
            ans.append(names[d[i][0]]).append('\n');
        }
        System.out.print(ans.toString());
    }
}
