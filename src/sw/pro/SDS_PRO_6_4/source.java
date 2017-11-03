package sw.pro.SDS_PRO_6_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] Hi = new int[N + 1];
        int eachHeight;
        int arrows = 0;
        for (int i = 1; i <= N; i++) {
            eachHeight = Integer.parseInt(st.nextToken());
            if (Hi[eachHeight] == 0) {
                arrows++;
            } else {
                Hi[eachHeight]--;
            }
            Hi[eachHeight - 1]++;
        }

        System.out.println(arrows);

    }
}
