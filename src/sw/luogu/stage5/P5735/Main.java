package sw.luogu.stage5.P5735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        double[] t = new double[6];
        for (int i = 0; i <6 ; i++) {
            in.nextToken();
            t[i] =  in.nval;
        }
        double len = 0;
        len = Math.sqrt(Math.pow(t[0]-t[2],2)+Math.pow(t[1]-t[3],2));
        len += Math.sqrt(Math.pow(t[4]-t[2],2)+Math.pow(t[5]-t[3],2));
        len += Math.sqrt(Math.pow(t[0]-t[4],2)+Math.pow(t[1]-t[5],2));
        System.out.println(String.format("%.2f",len));
    }
}
