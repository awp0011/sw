package sw.pro;

import java.util.ArrayList;
import java.util.Collections;

public class LongInteger {
    private static final int Warp = 10000;
    private static final ArrayList<Integer>[][] d = new ArrayList[202][102];

    public static void main(String[] args) throws Exception {

        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 100; j++) {
                d[i][j] = new ArrayList<>(200);
            }
        }
        dfsCombins(200, 100);
        ArrayList<Integer> ret = d[200][100];
        for (int i = ret.size() - 1; i >= 0; i--) {
            if (i < ret.size() - 1) System.out.printf("%04d",ret.get(i));
            else System.out.print(ret.get(i));
            //System.out.print(' ');
        }
        System.out.println();
    }

    private static ArrayList<Integer> dfsCombins(int n, int m) {
        if (d[n][m].size() > 0) return d[n][m];
        if (m == 1) {
            d[n][m].add(n);
            return d[n][m];
        }
        if (n == m) {
            d[n][m].add(1);
            return d[n][m];
        }
        if (n == 1) {
            d[n][m].add(1);
            return d[n][m];
        }
        dfsCombins(n - 1, m - 1);
        dfsCombins(n - 1, m);
        //d[n][m] =  + ;
        addArray(new int[]{n - 1, m - 1}, new int[]{n - 1, m}, new int[]{n, m});
        return d[n][m];
    }

    private static void addArray(int[] n, int[] m, int[] r) {
        ArrayList<Integer> ret = d[r[0]][r[1]];
        ArrayList<Integer> an = d[n[0]][n[1]];
        ArrayList<Integer> am = d[m[0]][m[1]];
        int carry = 0, i = 0, j = 0, idx = 0;
        int e1 = an.size(), e2 = am.size();

        int temSum;
        while (i < e1 && j < e2) {
            temSum = an.get(i++) + am.get(j++) + carry;
            carry = temSum / Warp;
            ret.add(idx++, temSum % Warp);
        }

        while (i < e1) {
            temSum = an.get(i++) + +carry;
            carry = temSum / Warp;
            ret.add(idx++, temSum % Warp);
        }

        while (j < e2) {
            temSum = am.get(j++) + carry;
            carry = temSum / Warp;
            ret.add(idx++, temSum % Warp);
        }

        while (carry > 0) {
            temSum = carry + (idx >= ret.size() ? 0 : ret.get(idx));
            carry = temSum / Warp;
            ret.add(idx++, temSum % Warp);
            //ret.set(idx++,temSum % Warp);
        }
    }
}
