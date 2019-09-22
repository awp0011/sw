package sw.luogu.stage2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;

public class P1338 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = parseLong(st.nextToken());
        long M = parseLong(st.nextToken());
        int[] arr = new int[(int)N + 5];
        int head = 1, tail = (int)N;
        for (int i = 1; i <= N; i++) {
            long t = (N - i) * (N - i - 1) >> 1;
            if (t >= M) {
                arr[head++] = i;
            } else {
                arr[tail--] = i;
                M -= (tail - head + 1);
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= N; i++) ans.append(arr[i]).append(' ');
        System.out.println(ans.toString());
    }
}
