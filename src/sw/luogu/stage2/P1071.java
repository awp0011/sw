package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1071 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] src = br.readLine().trim().toCharArray();
        int[] c1 = new int[src.length];
        for (int i = 0; i < src.length; i++) c1[i] = 1 + src[i] - 'A';
        src = br.readLine().trim().toCharArray();
        int[] map1 = new int[27];
        int[] map2 = new int[27];
        int cnt = 0;
        for (int i = 0; i < src.length; i++) {
            int t = 1 + src[i] - 'A';
            if (map1[c1[i]] == 0 && map2[t] == 0) {
                cnt++;
                map1[c1[i]] = t;
                map2[t] = c1[i];
            } else if (map1[c1[i]] != t || map2[t] != c1[i]) break;
        }
        if (cnt != 26) System.out.println("Failed");
        else {
            src = br.readLine().trim().toCharArray();
            for (int i = 0; i < src.length; i++) {
                int t = 1 + src[i] - 'A';
                System.out.print((char) (map1[t] + 64));
            }
            System.out.println();
        }
    }
}
