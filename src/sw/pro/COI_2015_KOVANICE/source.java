package sw.pro.COI_2015_KOVANICE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class source {
    private static Coin[] set;
    private static String EQ = "=";
    private static String LT = "<";

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        set = new Coin[M + 1];
        for (int i = 1; i <= M; i++) {
            set[i] = new Coin(i);
        }
        for (int i = 0; i < V; i++) {
            compare(bf.readLine());
        }
        bf.close();
        int cnt = 1;
        for (int i = 1; i <= M; i++) {
            Coin p = find(set[i]);
            if (p.sort == -1) {
                if (p.left.equals(p) && p.right.equals(p)) {
                    p.sort = 0;
                } else if (!p.left.equals(p)) {
                    p.sort = p.left.sort + 1;
                } else {
                    p.sort = 1;
                }

            }
            bw.append(p.getSort());
            bw.newLine();
        }
        Scanner sc = new Scanner(System.in);

        bw.flush();
        bw.close();
    }

    private static void compare(String tc) {
        int pos = tc.indexOf(EQ);
        String[] intArr = pos > 0 ? tc.split(EQ) : tc.split(LT);
        Coin A = set[Integer.parseInt(intArr[0])];
        Coin B = set[Integer.parseInt(intArr[1])];

        if (pos > 0) {
            union(A, B);
        } else {
            Coin pa = find(A);
            Coin pb = find(B);
            pa.right = pb;
            pb.left = pa;
        }

    }

    private static Coin find(final Coin c) {
        if (c.equals(c.parent)) return c.parent;
        c.parent = find(c.parent);
        return c.parent;
    }

    private static void union(final Coin c1, final Coin c2) {
        Coin p1 = find(c1);
        Coin p2 = find(c2);
        if (p1.equals(p2)) return;
        if (p1.index < p2.index) {
            p2.parent.parent = p1;
        } else {
            p1.parent.parent = p2;
        }
    }

    private static class Coin {
        int index;
        int sort;
        Coin left;
        Coin right;
        Coin parent;

        boolean equals(Coin o) {
            return o != null && o.index == index;
        }

        Coin(final int i) {
            index = i;
            sort = -1;
            parent = this;
            left = this;
            right = this;
        }

        String getSort() {
            if (sort == 0) return "?";
            return "K" + sort;
        }
    }


}
