package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1007 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int L = (int) in.nval;
        in.nextToken();
        int N = (int) in.nval;
        int maxn=0,minn=0;
        for (int i = 0; i <N ; i++) {
            in.nextToken();
            int pos = (int) in.nval;
            maxn = Math.max(maxn,Math.max(L-pos+1,pos));
            minn = Math.max(minn,Math.min(L-pos+1,pos));
        }
        System.out.println(minn+" "+maxn);
    }
}
