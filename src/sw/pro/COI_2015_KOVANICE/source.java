package sw.pro.COI_2015_KOVANICE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    private static Coin[] set;
    private static String EQ = "=";
    private static String LT = "<";

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());//种类
        int M = Integer.parseInt(st.nextToken());//coin 数量
        int V = Integer.parseInt(st.nextToken());//关系式数量
        set = new Coin[M + 1];
        for (int i = 1; i <= M; i++) {
            set[i] = new Coin(i);
        }
        for (int i = 0; i < V; i++) {
            compare(bf.readLine());
        }
        bf.close();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= M; i++) {
            Coin p = findParent(set[i]);
            if (p.sort == 0) {
                Coin f = findFirst(p);
                if (f.cnt == N) {
                    do {
                        f.sort = f.left.sort + 1;
                        f = f.right;
                    }
                    while (f.right.sort == 0);
                } else {
                    do {
                        f.sort = -1;
                        f = f.right;
                    }
                    while (f.right.sort == 0);
                }
            }
            sb.append(p.getSort()).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static void compare(String tc) {
        int pos = tc.indexOf(EQ);
        String[] intArr = pos > 0 ? tc.split(EQ) : tc.split(LT);
        Coin A = set[Integer.parseInt(intArr[0])];
        Coin B = set[Integer.parseInt(intArr[1])];

        if (pos > 0) {
            unionGroup(A, B);
        } else {
            unionRelation(A, B);
        }

    }

    private static Coin findParent(final Coin c) {
        if (c.equals(c.parent)) return c.parent;
        c.parent = findParent(c.parent);
        return c.parent;
    }

    private static Coin findFirst(final Coin c) {
        if (c.equals(c.first)) return c.first;
        c.first = findFirst(c.first);
        return c.first;
    }

    private static void unionGroup(final Coin c1, final Coin c2) {
        Coin p1 = findParent(c1);
        Coin p2 = findParent(c2);
        if (p1.equals(p2)) return;
        if (p1.index < p2.index) {
            p2.parent = p1;
        } else {
            p1.parent = p2;
        }


    }

    private static void unionRelation(final Coin c1, final Coin c2) {
        Coin pa = findParent(c1);
        Coin pb = findParent(c2);
        pa.right = pb;
        pb.left = pa;

        Coin f1 = findFirst(pa);
        Coin f2 = findFirst(pb);
        if (f1.equals(f2)) return;
        if (f1.index < f2.index) {
            f1.first.cnt += f2.first.cnt;
            f2.first = f1.first;

        } else {
            f2.first.cnt += f1.first.cnt;
            f1.first = f2.first;
        }
    }

    private static class Coin {
        int index;
        int sort;
        int cnt;
        Coin left;
        Coin right;
        Coin parent;
        Coin first;


        boolean equals(Coin o) {
            return o != null && o.index == index;
        }

        Coin(final int i) {
            index = i;
            sort = 0;
            parent = this;
            left = this;
            right = this;
            cnt = 1;
            first = this;
        }

        String getSort() {
            if (sort == -1) return "?";
            return "K" + sort;
        }
    }


}
