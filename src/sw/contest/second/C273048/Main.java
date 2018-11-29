package sw.contest.second.C273048;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;
import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());
        int[] C = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            C[i] = parseInt(st.nextToken());
        }

        int MIN_TIME = MAX_VALUE;
        int start = 0, end = start + K - 1;
        while (end < N) {
            MIN_TIME = min(MIN_TIME, min(abs(C[start]), abs(C[end])) + C[end] - C[start]);
            start++;
            end = start + K - 1;

        }
        System.out.println(MIN_TIME);
    }
}