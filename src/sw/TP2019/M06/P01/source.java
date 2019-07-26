package sw.TP2019.M06.P01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N + 5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(st.nextToken());
            int key = Arrays.binarySearch(a, 0, ans + 1, c);
            if (key < 0) {
                key = Math.abs(key + 1);
                a[key] = c;
                if (key > ans) ans++;
            }
        }
        System.out.println(ans);
    }
}
