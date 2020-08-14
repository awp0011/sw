package sw.luogu.stage5.P2249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[] d = new int[n + 3];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            d[i] = (int) in.nval;
        }

        StringBuilder ans = new StringBuilder();
        for(int j=0;j<m;++j){
            in.nextToken();
            int v = (int) in.nval;
            int lo = 0;
            int hi = n-1;
            while(lo<hi){
                int mi = lo+hi; mi >>= 1;
                int ck = d[mi];
                if(v <= ck){
                    hi = mi;
                }else{
                    lo = mi+1;
                }
            }
            ans.append(d[lo]==v?(lo+1):-1).append(' ');
        }
        System.out.println(ans.toString());
    }
}
