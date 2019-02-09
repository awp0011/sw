package sw.TP2019.M05.P01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());
        Volume[] mb = new Volume[N + K];
        int i = 0;
        for (; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            mb[i] = new Volume(parseInt(st.nextToken()), parseInt(st.nextToken()));
        }
        for (; i < N + K; i++) {
            mb[i] = new Volume(parseInt(br.readLine()));

        }
        br.close();
        Arrays.sort(mb, (e1, e2) -> {
            if (e1.Mi == e2.Mi) {
                return e2.Vi - e1.Vi;
            } else {
                return e1.Mi - e2.Mi;
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int j = 0; j < N + K; j++) {
            if (mb[j].Vi != -1) queue.offer(mb[j].Vi);
            else if (!queue.isEmpty()) ans += queue.poll();
        }
        System.out.println(ans);
    }

    private static class Volume {
        final int Mi;
        final int Vi;

        Volume(int m) {
            Mi = m;
            Vi = -1;
        }

        Volume(int m, int v) {
            Mi = m;
            Vi = v;
        }
    }
}
