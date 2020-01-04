package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1615 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h1 = Integer.parseInt(st.nextToken(":"));
        int m1 = Integer.parseInt(st.nextToken(":"));
        int s1 = Integer.parseInt(st.nextToken(":"));

        st = new StringTokenizer(br.readLine());
        int h2 = Integer.parseInt(st.nextToken(":"));
        int m2 = Integer.parseInt(st.nextToken(":"));
        int s2 = Integer.parseInt(st.nextToken(":"));

        long c = Integer.parseInt(br.readLine());
        c *= ((((h2 - h1) * 60) + (m2 - m1)) * 60 + (s2 - s1)) ;
        System.out.println(c);
    }
}
