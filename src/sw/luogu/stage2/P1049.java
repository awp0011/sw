package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1049 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int V = (int) in.nval;
        in.nextToken();
        int n = (int) in.nval;
        int[] boxes = new int[V + 3];
        int[] weight = new int[n + 3];
        for (int i = 1; i <= n; i++) {
            in.nextToken();
            weight[i] = (int) in.nval;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= weight[i]; j--) {
                boxes[j] = Math.max(boxes[j], boxes[j - weight[i]] + weight[i]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= V; i++) {
            ans = Math.max(ans, boxes[i]);
        }
        System.out.println(V - ans);
    }

}
