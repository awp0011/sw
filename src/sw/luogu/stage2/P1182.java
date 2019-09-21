package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P1182 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int[] d = new int[N];
        int L = 0, R = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            d[i] = parseInt(st.nextToken());
            if (d[i] > L) L = d[i];
            R += d[i];
        }
        int MID, CNT, SUM;
        while (L <= R) {
            MID = (L + R) >> 1;
            CNT = 0;
            SUM = 0;
            for (int i = 0; i < N; i++) {
                if (SUM + d[i] <= MID) {
                    SUM += d[i];
                } else {
                    SUM = d[i];
                    CNT++;
                    if (CNT > M) break;
                }
            }

            if (CNT < M) R = MID - 1;
            else L = MID + 1;

        }
        System.out.println(L);
    }


}
