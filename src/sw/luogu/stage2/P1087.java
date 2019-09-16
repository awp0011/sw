package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1087 {
    private static int[] tree;
    private static StringBuilder ans = new StringBuilder();
    private static int offset;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        offset = 1 << n;
        tree = new int[offset << 1];
        String str = br.readLine();
        for (int i = 0; i < offset; i++) {
            update(offset + i, str.charAt(i) == '0' ? 'B' : 'I');
        }
        printTree(1);
        System.out.println(ans.toString());
    }

    private static void printTree(int node) {
        if (node < offset) {
            printTree(node * 2);
            printTree(node * 2 + 1);
        }
        ans.append((char)tree[node]);

    }

    private static void update(int p, char c) {
        while (p > 0) {
            if (tree[p] == 0) tree[p] = c;
            else if (tree[p] != c) tree[p] = 'F';
            p >>= 1;
        }
    }
}
