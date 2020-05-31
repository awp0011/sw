package sw.luogu.stage5.P5729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int w = (int) in.nval;
        in.nextToken();
        int x = (int) in.nval;
        in.nextToken();
        int h = (int) in.nval;
        int[][][] cube = new int[w + 1][x + 1][h + 1];
        in.nextToken();
        int n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            int s1 = (int) in.nval;
            in.nextToken();
            int s2 = (int) in.nval;
            in.nextToken();
            int s3 = (int) in.nval;

            in.nextToken();
            int e1 = (int) in.nval;
            in.nextToken();
            int e2 = (int) in.nval;
            in.nextToken();
            int e3 = (int) in.nval;

            for (int a1 = s1; a1 <= e1; a1++) {
                for (int a2 = s2; a2 <= e2; a2++) {
                    for (int a3 = s3; a3 <= e3; a3++) {
                        cube[a1][a2][a3] = 1;
                    }
                }
            }
        }
        int sum = 0;
        for (int a1 = 1; a1 <= w; a1++) {
            for (int a2 = 1; a2 <= x; a2++) {
                for (int a3 = 1; a3 <= h; a3++) {
                    if (cube[a1][a2][a3] == 0) sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
