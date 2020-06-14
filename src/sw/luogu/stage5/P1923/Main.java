package sw.luogu.stage5.P1923;

import java.io.*;
import java.util.*;

public class Main {
    private static int[] x;//[5000005]
    private static int n, k;
    private static int lenbuf = 0, ptrbuf = 0;
    private static byte[] inbuf = new byte[2];
    private static InputStream is;


    public static void main(String[] args){
        is = System.in;
        n = ni();
        k = ni();
        x = new int[n + 5];
        for (int i = 0; i < n; i++) x[i] = ni();

        qsort(0, n - 1);

    }

    private static void qsort(int l, int r) {
        int i = l, j = r, mid = x[(l + r) / 2];
        do {
            while (x[j] > mid)
                j--;
            while (x[i] < mid)
                i++;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        while (i <= j);
        //快排后数组被划分为三块： l<=j<=i<=r
        if (k <= j) qsort(l, j);//在左区间只需要搜左区间
        else if (i <= k) qsort(i, r);//在右区间只需要搜右区间
        else //如果在中间区间直接输出
        {
            System.out.println(x[j + 1]);
            System.exit(0);
        }
    }

    private static void swap(int i, int j) {
        int t = x[i];
        x[i] = x[j];
        x[j] = t;
    }

    private static int ni() {
        int num = 0, b;
        boolean minus = false;
        while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) {
        }
        ;
        if (b == '-') {
            minus = true;
            b = readByte();
        }
        while (true) {
            if (b >= '0' && b <= '9') num = (num << 3) + (num << 1) + (b - '0');
            else return minus ? -num : num;
            b = readByte();
        }
    }


    private static int readByte() {
        if (lenbuf == -1) throw new InputMismatchException();
        if (ptrbuf >= lenbuf) {
            ptrbuf = 0;
            try {
                lenbuf = is.read(inbuf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (lenbuf <= 0) return -1;
        }
        return inbuf[ptrbuf++];
    }
}
