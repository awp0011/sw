package sw.luogu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1308 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine().toLowerCase();
        String line = br.readLine().toLowerCase();

        StringTokenizer st = new StringTokenizer(line);
        int c = 0;
        while (st.hasMoreTokens()) {
            if (target.equals(st.nextToken())) c++;
        }
        if (c == 0) System.out.println(-1);
        else {
            int f;
            if (line.startsWith(target + " ")) f = 0;
            else f = line.indexOf(" " + target + " ") + 1;
            System.out.println(c + " " + f);
        }
    }

}
