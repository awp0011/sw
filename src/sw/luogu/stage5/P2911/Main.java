package sw.luogu.stage5.P2911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int s1 = (int) in.nval;
        in.nextToken();
        int s2 = (int) in.nval;
        in.nextToken();
        int s3 = (int) in.nval;
        int[] cnt = new int[82];
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    cnt[i + j + k]++;
                }
            }
        }
        int max = 0, idx = 0;
        for (int i = 0; i < 82; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                idx = i;
            }
        }
        System.out.println(idx);
    }
}
