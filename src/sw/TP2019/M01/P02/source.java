package sw.TP2019.M01.P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] height = new int[1_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int hi = Integer.parseInt(st.nextToken());
            if (height[hi] == 0) {
                answer++;
            } else {
                height[hi]--;
            }
            height[hi - 1]++;
        }
        System.out.println(answer);
    }
}
