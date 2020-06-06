package sw.luogu.stage5.P5742;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        StringBuilder ans = new StringBuilder();
        int ss;
        int es;
        double zs;
        for (int i = 0; i <n ; i++) {
            in.nextToken();
            in.nextToken();
            ss =(int) in.nval;
            in.nextToken();
            es =(int) in.nval;
            zs = 0.7 * ss + 0.3 * es;
            if(ss+es>140&&zs>=80)ans.append("Excellent").append('\n');
            else ans.append("Not excellent").append('\n');
        }
        System.out.println(ans.toString());
    }

}
