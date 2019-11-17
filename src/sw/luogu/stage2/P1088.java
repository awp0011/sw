package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class P1088 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            a[i] = (int) in.nval;
        }

        for (int i = 0; i < m; i++) nextPermutation(a);
        StringBuilder ans = new StringBuilder();
        ans.append(a[0]);
        for (int i = 1; i < n; i++) ans.append(' ').append(a[i]);
        System.out.println(ans.toString());
    }

    private static void nextPermutation(int[] num) {
        if (num.length <= 1)
            return;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                int j;
                for (j = num.length - 1; j >= i; j--)
                    if (num[i] < num[j])
                        break;
                // swap the two numbers.
                num[i] = num[i] ^ num[j];
                num[j] = num[i] ^ num[j];
                num[i] = num[i] ^ num[j];
                //sort the rest of arrays after the swap point.
                Arrays.sort(num, i + 1, num.length);
                return;
            }
        }
        //reverse the arrays.
        for (int i = 0; i < num.length / 2; i++) {
            int tmp = num[i];
            num[i] = num[num.length - i - 1];
            num[num.length - i - 1] = tmp;
        }
        return;
    }

}
