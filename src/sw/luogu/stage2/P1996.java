package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1996 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        if (n == 0) {
            System.out.println();
            System.exit(0);
        }
        Y head = new Y(1);
        Y tail = new Y(n);
        head.next = tail;
        tail.pre = head;
        head.pre = tail;
        tail.next = head;

        for (int i = 2; i < n; i++) {
            Y y = new Y(i);
            tail.pre.next = y;
            y.pre = tail.pre;
            tail.pre = y;
            y.next = tail;
        }
        Y cu = head;
        int i = 1;
        StringBuilder ans = new StringBuilder();
        while (cu.i != cu.pre.i) {
            if (i % m == 0) {
                cu.pre.next = cu.next;
                cu.next.pre = cu.pre;
                ans.append(cu.i).append(' ');
            }
            i++;
            cu = cu.next;
        }
        ans.append(cu.i);
        System.out.println(ans.toString());
    }

    private static class Y {
        int i;
        Y pre;
        Y next;

        Y(int n) {
            i = n;
        }
    }
}
