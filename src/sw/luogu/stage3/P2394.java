package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P2394 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        int len = str.length();
        if (len > 11) str = str.substring(0, 11);
        double n = Double.parseDouble(str);
        System.out.println(String.format("%.8f", n / 23));
    }
}
