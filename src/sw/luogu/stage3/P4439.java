package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P4439 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String p1 = "", p2 = "";
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            p1 = br.readLine();
            if (!p1.equals(p2)) cnt++;
            p2 = p1;
        }
        System.out.println(cnt);
    }
}
