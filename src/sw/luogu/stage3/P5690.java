package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5690 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mm = Integer.parseInt(st.nextToken("-"));
        int dd = Integer.parseInt(st.nextToken("-"));
        int cnt = 0;
        if (mm == 0) cnt++;
        else if (mm > 12) cnt++;
        if (mm == 2 && dd > 28) cnt++;
        else if (dd > 31) cnt++;
        else if (dd == 0) cnt++;

        System.out.println(cnt);
    }
}
