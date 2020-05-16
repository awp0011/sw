package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5716 {
    private static final int[] month = new int[]{0, 31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int yyyy = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());
        if (mm == 2) {
            if (yyyy % 100 != 0 && yyyy % 4 == 0) System.out.println(29);
            else if (yyyy % 400 == 0) System.out.println(29);
            else System.out.println(28);
        } else {
            System.out.println(month[mm]);
        }
    }

}
