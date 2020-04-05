package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5660 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chs = br.readLine().toCharArray();
        int cnt = 0;
        for (char c : chs) if (c == '1') cnt++;
        System.out.println(cnt);
    }
}
