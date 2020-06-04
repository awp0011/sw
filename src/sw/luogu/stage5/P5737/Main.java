package sw.luogu.stage5.P5737;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int x = (int) in.nval;

        in.nextToken();
        int y = (int) in.nval;
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = x; i <= y; ) {
            if (isleap(i)) {
                ans.append(i).append(' ');
                cnt++;
                i += 4;
            } else {
                if (cnt == 0) i++;
                else i += 4;
            }
        }
        System.out.println(cnt);
        System.out.println(ans.toString());
    }

    private static boolean isleap(int i) {
        if (i % 400 == 0) {
            return true;
        } else if (i % 100 == 0) {
            return false;
        } else {
            return i % 4 == 0;
        }
    }
}
