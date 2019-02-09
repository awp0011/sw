package sw.TP2019.M05.P01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());
        PriorityQueue<Mine> queue = new PriorityQueue<>((e1, e2) -> e2.getVi() - e1.getVi());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            queue.offer(new Mine(parseInt(st.nextToken()), parseInt(st.nextToken())));
        }
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = parseInt(br.readLine());
        }

        Arrays.sort(bags);
        int cnt = 0;
        long ans = 0;
        int prve = K;
        while (cnt < K && !queue.isEmpty()) {
            Mine m = queue.poll();
            int index = Arrays.binarySearch(bags, 0, prve, m.Mi);
            if (index < 0) {
                index = Math.abs(index + 1);
            } else if (index < bags.length) {
                index++;
            }
            if (index >= bags.length) continue;
            ans += m.Vi * (prve - index);
            cnt += (prve - index);
            prve = index;
        }
        System.out.println(ans);
    }

    private static class Mine {
        final int Mi;
        final int Vi;
        Mine(int m, int v) {
            Mi = m;
            Vi = v;
        }
        int getVi() {
            return Vi;
        }

    }
}
