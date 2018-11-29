package sw.contest.second.A273048;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        String name;
        int cnt = 2;
        for (int i = 0; i < N; i++) {
            name = br.readLine();
            cnt += (name.length() > 4 && name.charAt(name.length() - 4) == '+') ? 2 : 1;
        }
        br.close();
        if (cnt == 13) cnt++;
        System.out.println(cnt * 100);
    }
}
