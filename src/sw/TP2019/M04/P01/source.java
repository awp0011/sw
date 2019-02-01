package sw.TP2019.M04.P01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class source {
    private final static int offset = 10_000_000;
    private static int[] woods;
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine()) * offset;
        N = Integer.parseInt(br.readLine());
        if (N == 0) {
            System.out.println("danger");
        } else {
            woods = new int[N];
            for (int i = 0; i < N; i++) {
                woods[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(woods);

            int left = 0, right = N - 1;
            int temp = 0;
            while (left < right) {
                temp = woods[left] + woods[right];
                if (temp == size) {
                    System.out.printf("yes %d %d", woods[left], woods[right]);
                    break;
                } else if (temp < size) {
                    left++;
                } else {
                    right--;
                }
            }
            if (temp != size) {
                System.out.println("danger");
            }
        }

    }


}
