package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class P5594 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        BitSet[] bs = new BitSet[k+1];
        int[] CNTs = new int[k+1];
        for (int i = 0; i <= k; i++) bs[i] = new BitSet();
        int t, index;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            index = 1;
            for (int j = 1; j <= m; j++) {
                t = Integer.parseInt(st.nextToken());
                if(!bs[t].get(index)){
                    CNTs[t]++;
                }
                bs[t].set(index++);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= k; i++) {
            ans.append(CNTs[i]).append(' ');
        }
        System.out.println(ans.toString());
    }
}
