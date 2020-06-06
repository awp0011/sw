package sw.luogu.stage5.P2415;

import java.io.*;
import java.util.ArrayList;

public class Main {
    static int cnt=0;
    static long tot = 0;

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("C:\\Users\\peng0\\Downloads\\P2415_2.in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            tot += (int) in.nval;
            cnt++;
        }
        tot *= Math.pow(2,cnt-1);
        System.out.println(tot);
    }


}
