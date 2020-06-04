package sw.luogu.stage5.P1320;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\workspace\\idea\\sw\\src\\sw\\luogu\\stage5\\P1320\\cast.input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int row = 0, cnt = 0;
        char pre = '0';
        StringBuilder seq = new StringBuilder();
        while (br.ready()) {
            row++;
            String src = br.readLine();
            for (int i = 0; i < src.length(); i++) {
                if (src.charAt(i) == pre) cnt++;
                else {
                    pre = src.charAt(i);
                    seq.append(' ').append(cnt);
                    cnt = 1;
                }
            }
        }
        seq.append(' ').append(cnt);
        System.out.print(row);
        System.out.print(seq.toString());
        if (pre == '0') {
            System.out.print(' ');
            System.out.print(0);
        }
    }
}
