package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P5681 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        long a = (long)in.nval;
        in.nextToken();
        long b = (long)in.nval;
        in.nextToken();
        long c = (long)in.nval;

        if(a*a>b*c) System.out.println("Alice");
        else System.out.println("Bob");
    }

}
