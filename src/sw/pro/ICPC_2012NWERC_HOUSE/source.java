package sw.pro.ICPC_2012NWERC_HOUSE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine()) * 10_000_000;
        int N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println("danger");
        } else {
            int[] Li = new int[N];
            for (int i = 0; i < N; i++) {
                Li[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(Li);
            int left = 0, right = N - 1;
            int answer = 0, L1 = Li[left], L2 = Li[right];

            while (left < right) {
                answer = L1 + L2;
                if (answer > X) {
                    right--;
                    if (right < N) L2 = Li[right];
                    else break;
                } else if (answer < X) {
                    left++;
                    if (left >= 0) L1 = Li[left];
                    else break;
                } else {
                    break;
                }

            }
            if (answer != X) {
                System.out.println("danger");
            } else {
                System.out.println("yes" + " " + L1 + " " + L2);
            }
        }
    }
}
