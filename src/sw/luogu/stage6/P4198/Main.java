package sw.luogu.stage6.P4198;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int[] tree = new int[300003];
    static int offset, MaxX, MaxY;
    static StreamTokenizer in;
    static PrintWriter out;

    static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        int m = nextInt();
        offset = 1;
        while (offset <= n) offset <<= 1;
        offset--;
        MaxX = 0;
        MaxY = 0;
        for (int i = 0; i < m; i++) {
            int x = nextInt();
            int y = nextInt();
            update(x);
            if (y > MaxY) MaxX = x;
            else if (y == MaxY) MaxX = Math.min(MaxX, x);
            out.println(query(MaxX));
        }
        out.flush();
    }

    static void update(int pos) {
        int idx = offset + pos;
        while (idx > 0) {
            tree[idx] += 1;
            idx >>= 1;
        }
    }

    static int query(int pos) {
        int s = offset + 1;
        int e = offset + pos;
        int sum = 0;
        while (s <= e) {
            if (s % 2 == 1) sum += tree[s++];
            if (e % 2 == 0) sum += tree[e--];
            s >>= 1;
            e >>= 1;
        }
        return sum;
    }
}