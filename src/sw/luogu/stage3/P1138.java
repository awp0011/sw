package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class P1138 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        boolean[] cnts = new boolean[30001];
        int f=0;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            cnts[(int) in.nval] =true;
        }
        for (int i = 0; i <30001 ; i++) {
            if(cnts[i])f++;
            if (f==k){
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println("NO RESULT");
    }
}
