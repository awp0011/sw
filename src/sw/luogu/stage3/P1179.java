package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1179 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = s; i <= e; i++) {
            int next = i;
            while (next > 0) {
                if (next % 10 == 2) cnt++;
                next /= 10;
            }
        }
        System.out.println(cnt);
    }

}
