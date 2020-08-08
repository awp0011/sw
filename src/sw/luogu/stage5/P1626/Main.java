package sw.luogu.stage5.P1626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] d = new int[n];
        for (int i = 0; i <n ; i++) {
            in.nextToken();
            d[i] = (int) in.nval;
        }
        Arrays.sort(d);
        for (int i = 1; i <n ; i++) {
            pq.add(d[i]-d[i-1]);
        }
        int ans = 0;
        for (int i = 0; i <k ; i++) {
            ans += pq.poll();
        }
        System.out.println(ans);
    }
}
