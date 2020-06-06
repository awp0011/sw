package sw.luogu.stage5.P5740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        String[] names = new String[n];
        int[][] s = new int[n][4];
        int idx = -1, max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            s[i][1] = parseInt(st.nextToken());
            s[i][2] = parseInt(st.nextToken());
            s[i][3] = parseInt(st.nextToken());
            s[i][0] = s[i][1] + s[i][2] + s[i][3];
            if (s[i][0] > max) {
                idx = i;
                max = s[i][0];
            }
        }
        System.out.println(names[idx] + " " + s[idx][1] + " " + s[idx][2] + " " + s[idx][3]);
    }
}
