package sw.luogu.stage3;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

class InputReader {
    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, snumChars;

    public InputReader(InputStream st) {
        this.stream = st;
    }

    public int read() {
        if (snumChars == -1)
            throw new InputMismatchException();
        if (curChar >= snumChars) {
            curChar = 0;
            try {
                snumChars = stream.read(buf);
            } catch (IOException e) {
                // TODO: handle exception
                throw new InputMismatchException();
            }
            if (snumChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] nextIntArray(int n) {
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }
        return a;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    private boolean isEndOfLine(int c) {
        // TODO Auto-generated method stub
        return c == '\n' || c == '\r' || c == -1;
    }

    private boolean isSpaceChar(int c) {
        // TODO Auto-generated method stub
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}

public class P3374Ex {
    static int[] tree;

    public static void main(String[] args) {
        //Scanner sc=new Scanner(System.in);
        InputReader sc = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = sc.nextInt();
        int m = sc.nextInt();

        tree = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            int x = sc.nextInt();
            add(i, x, n + 1);
            //now=x;
        }

        for (int i = 0; i < m; i++) {
            int style = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();
            if (style == 1) {


                add(l, r, n + 1);
            } else if (style == 2) {
                long out1 = query(l, r);
                out.println(out1);
            }
        }
        out.flush();
        out.close();

    }


    private static void add(int i, int x, int n) {
        // TODO Auto-generated method stub
        while (i < n) {
            tree[i] += x;
            i += i & (-i);
        }

    }

    private static long sum(int r) {
        long sum = 0;
        while (r > 0) {
            sum += tree[r];
            r -= r & (-r);
        }
        return sum;
    }

    private static long query(int r, int l) {
        long sum1 = sum(l);
        sum1 -= sum(r - 1);
        return sum1;
    }


}