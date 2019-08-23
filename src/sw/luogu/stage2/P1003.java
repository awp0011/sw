package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        int[][] Carpets = new int[n + 1][4];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Carpets[i][0] = parseInt(st.nextToken());
            Carpets[i][1] = parseInt(st.nextToken());
            Carpets[i][2] = Carpets[i][0] + parseInt(st.nextToken());
            Carpets[i][3] = Carpets[i][1] + parseInt(st.nextToken());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = parseInt(st.nextToken());
        int y = parseInt(st.nextToken());

        while (n >= 1) {
            if (x >= Carpets[n][0] && x <= Carpets[n][2]) {
                if (y >= Carpets[n][1] && y <= Carpets[n][3]) {
                    break;
                }
            }
            n--;
        }
        if (n == 0) System.out.println(-1);
        else System.out.println(n);
    }
}
