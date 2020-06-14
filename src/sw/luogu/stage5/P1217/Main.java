package sw.luogu.stage5.P1217;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;

        int[] nums = new int[n + 3];
        for (int i = 0; i < m; i++) {
            in.nextToken();
            nums[(int) in.nval]++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            while (nums[i] > 0) {
                ans.append(i).append(' ');
                nums[i]--;
            }
        }
        System.out.println(ans.toString());
    }
}
