package sw.luogu.stage5.P2676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int s = (int) in.nval;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i <n ; i++) {
            in.nextToken();
            pq.add((int) in.nval);
        }
        int cnt=0,sum=0;
        while (sum<s){
            cnt++;
            sum += pq.poll();
        }
        System.out.println(cnt);
    }
}
