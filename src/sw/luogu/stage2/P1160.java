package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1160 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        STU[] all = new STU[n + 2];
        STU head = new STU(0);
        all[0] = head;
        all[1] = new STU(1);
        STU tail = new STU(n + 1);
        all[n + 1] = tail;
        head.left = head;
        head.right = all[1];
        all[1].left = head;
        all[1].right = tail;
        tail.left = all[1];
        tail.right = tail;

        for (int i = 2; i <= n; i++) {
            st.nextToken();
            int k = (int) st.nval;
            st.nextToken();
            int p = (int) st.nval;

            all[i] = new STU(i);
            if (p == 0) {
                all[i].left = all[k].left;
                all[k].left.right = all[i];
                all[k].left = all[i];
                all[i].right = all[k];
            } else {
                all[i].right = all[k].right;
                all[k].right.left = all[i];
                all[k].right = all[i];
                all[i].left = all[k];
            }
        }
        st.nextToken();
        int m = (int) st.nval;
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int x = (int) st.nval;
            if (all[x] != null && !all[x].isDel) all[x].del();
        }
        StringBuilder ans = new StringBuilder();
        STU next = all[0].right;
        while (next.NO != tail.NO) {
            ans.append(next.NO).append(' ');
            next = next.right;
        }
        System.out.println(ans.toString());
    }

    private static class STU {
        int NO;
        STU left;
        STU right;
        boolean isDel;

        STU(int n) {
            NO = n;
            isDel = false;
        }

        void del() {
            isDel = true;
            left.right = right;
            right.left = left;
        }
    }
}
