package sw.pro.SDS_PRO_2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class source {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] all = new long[N + 1];

        for (int t = 0; t < N; t++) {
            all[t] = Long.valueOf(br.readLine());

        }
        Arrays.sort(all);
        long max = 0, index = 0, counter = 1;
        for (int t = 0; t < N; t++) {
            if (all[t] == all[t + 1]) counter++;
            else counter = 1;
            if (max < counter) {
                max = counter;
                index = all[t];
            }

        }
        System.out.println(index);
        br.close();
    }


}
