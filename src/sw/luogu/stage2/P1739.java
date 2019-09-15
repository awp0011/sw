package sw.luogu.stage2;

import java.io.BufferedReader;
        import java.io.InputStreamReader;

public class P1739 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] str = in.readLine().toCharArray();
        int cnt = 0;
        for (char c : str) {
            if(c=='(')cnt++;
            else if(c==')')cnt--;
            if(cnt<0) break;
        }
        if(cnt==0) System.out.println("YES");
        else System.out.println("NO");
    }

}
