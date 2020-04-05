package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2955 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        String src ;
        int size,next=0;
        for (int i = 0; i < n; i++) {
            src = br.readLine();
            size = src.length();
            next = src.charAt(size-1)-'0';
            ans.append(next % 2 == 0 ? "even" : "odd").append('\n');
        }
        System.out.println(ans.toString());
    }
}
