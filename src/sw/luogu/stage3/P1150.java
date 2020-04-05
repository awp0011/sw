package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1150 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int cnt = n, l;
        do {
            l = n % k;
            n /= k;
            cnt += n;
            n += l;
        } while (n >= k);
        System.out.println(cnt);
    }

}
