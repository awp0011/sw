package sw.pro.SDS_PRO_7_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class source2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] milestone = new int[N + 1];
        for (int i = 0; i < N; i++) {
            milestone[i] = Integer.parseInt(br.readLine());
        }
        milestone[milestone.length - 1] = L;
        LinkedList<Trip> all = new LinkedList<>();
        all.add(new Trip(M, 0, -1));
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < milestone.length; i++) {
            while (!all.isEmpty()&&all.peek().visitor != i) {
                Trip t = all.pop();
                if (t.Max >= L) {
                    if (answer > t.counter) answer = t.counter;
                } else if (t.Max >= milestone[i]) {
                    Trip t0 = new Trip(t.Max+M, t.counter+1, i);
                    all.add(t0);
                    all.add(t);
                }
            }
        }
//        while (!all.isEmpty()) {
//            Trip t = all.pop();
//            if (t.Max >= L) {
//                if (answer > t.counter) answer = t.counter;
//            }
//        }
        System.out.println(answer);
    }

    private static class Trip {
        int Max;
        int counter;
        int visitor;

        Trip(final int m, final int c, final int v) {
            Max = m;
            counter = c;
            visitor = v;
        }
    }
}
