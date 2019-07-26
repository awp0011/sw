package sw.TP2019.M06.P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] history = new int[1_000_005];
        int[] born = new int[1_000_005];
        int[] live = new int[1_000_005];
        history[0] = 1;
        born[0] = 1;
        live[0] = 1;
        for (int i = 1; i <= N; i++) {
            if (i >= a) born[i] = history[i - a];
            if (i >= b) born[i] -= history[i - b];
            history[i] = history[i - 1] + born[i];
            live[i] = live[i - 1] + born[i];
            if (i >= d) live[i] -= born[i - d];
            live[i] = (live[i] + 1000) % 1000;
            history[i] = (history[i] + 1000) % 1000;
            born[i] = (born[i] + 1000) % 1000;
        }
        System.out.println(live[N]);
    }
}
