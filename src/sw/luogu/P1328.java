package sw.luogu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P1328 {
    private static final int[][] wl = new int[][]{
            {0, 0, 1, 1, 0},
            {1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {1, 1, 0, 0, 0}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int NA = parseInt(st.nextToken());
        int NB = parseInt(st.nextToken());

        int[] dA = new int[NA];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NA; i++) dA[i] = parseInt(st.nextToken());
        int[] dB = new int[NB];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < NB; i++) dB[i] = parseInt(st.nextToken());
        int ans1 = 0, ans2 = 0, pos1 = 0, pos2 = 0;
        while (N > 0) {
            ans1 += wl[dA[pos1]][dB[pos2]];
            ans2 += wl[dB[pos2]][dA[pos1]];
            N--;
            pos1++;
            pos1 %= NA ;
            pos2++;
            pos2 %= NB ;
        }
        System.out.println(ans1 + " " + ans2);
    }
}
