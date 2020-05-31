package sw.luogu.stage5.P5730;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    private static final String[] base = new String[]{
            "XXX..XXXXXXXX.XXXXXXXXXXXXXXXX",
            "X.X..X..X..XX.XX..X....XX.XX.X",
            "X.X..XXXXXXXXXXXXXXXX..XXXXXXX",
            "X.X..XX....X..X..XX.X..XX.X..X",
            "XXX..XXXXXXX..XXXXXXX..XXXXXXX"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String src = in.readLine();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                int pos = src.charAt(j)-'0';
                if(j>0)ans.append('.');
                ans.append(base[i].charAt(pos*3)).append(base[i].charAt(pos*3+1)).append(base[i].charAt(pos*3+2));
            }
            ans.append('\n');
        }
        System.out.println(ans.toString());
    }
}
