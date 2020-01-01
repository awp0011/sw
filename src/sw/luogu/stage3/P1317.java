package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1317 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            d[i] = Integer.parseInt(st.nextToken());
            if (i > 1) {
                if (d[i - 2] >= d[i - 1] && d[i - 1] < d[i]) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
