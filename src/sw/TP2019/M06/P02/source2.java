package sw.TP2019.M06.P02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class source2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        Bag[] A = new Bag[N];
        A[0] = new Bag(0, 0);
        for (int i = 0; i < N; i++) {
            A[i] = new Bag(i, parseInt(br.readLine()));
        }
        Arrays.sort(A, Comparator.comparingInt(Bag::getW));
        int sum, cnt, next;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (A[i].v) continue;
            A[i].v = true;
            if (A[i].id == i) continue;
            cnt = 0;
            sum = 0;
            next = A[i].id;
            while (!A[next].v) {
                ++cnt;
                sum += A[next].w;
                A[next].v = true;
                next = A[next].id;
            }
            ans += Math.min(A[0].w * (cnt + 2) + A[i].w * 2, A[i].w * cnt) + sum;
        }
        System.out.println(ans);
    }

    private static class Bag {
        final int id;
        final int w;
        boolean v;

        Bag(final int b, final int v) {
            id = b;
            w = v;
        }


        int getW() {
            return w;
        }


    }
}
