package sw.TP2019.M01.P03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        People[] all = new People[N];
        for (int i = 0; i < N; i++) {
            all[i] = new People();
            all[i].index = i + 1;
            if (i > 0) {
                all[i-1].next = all[i];
            }
        }
        all[N-1].next=all[0];
        int K = Integer.parseInt(st.nextToken());
        br.close();
        People current = all[0];
        People previous = all[N-1];
        int index = 0;
        while (current.next.index != current.index) {
            if (index  % K == 0) {
                System.out.print(current.index + " ");
                previous.next = current.next;
                index = 1;
            }else {
                previous = current;
                index++;
            }

            current = current.next;

        }
        System.out.println(current.index );

    }

    static class People {
        int index;
        People next;
    }
}
