package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2708 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s = br.readLine().toCharArray();
        int cnt = 0;
        char pre = s[0];
        for (int i = 1; i < s.length; i++) {
            if (s[i] == s[i-1]) continue;
            else {
                if (s[i - 1] == '0' && pre == '1') cnt += 2;
                if (s[i - 1] == '0' && pre == '0') cnt += 1;
                else if (s[i - 1] == '1' && pre == '0') cnt += 1;
                pre = s[i - 1]='1';
            }
        }
        if (s.length == 1 && s[0] == '0') cnt++;
        else if (s[s.length-1] == '0') cnt += 2;
        System.out.println(cnt);
    }
}
