package sw.pro.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class IndexedTree {
    private static final int[] tree = new int[270000];
    private static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        //找到第一个大于等于N的 2的次方数
        int tmpN = 0;
        for (tmpN = 1; tmpN <= N; tmpN *= 2) ;

        //init data
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i + tmpN] = Integer.parseInt(st.nextToken());
        }
        for (int i = tmpN - 1; i >= 1; i--) {
            tree[i] = Math.min(tree[i * 2], tree[i * 2 + 1]);
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (c == 0) {
                int min = Integer.MAX_VALUE;
                x += tmpN - 1;
                y += tmpN - 1;
                while (x <= y) {
                    if (x % 2 == 1) min = Math.min(tree[x], min);
                    if (y % 2 == 0) min = Math.min(tree[y], min);
                    x = (x + 1) >> 1;
                    y = (y - 1) >> 1;
                }
                System.out.println(min);
            } else {
                tree[x + tmpN - 1] = y;
                x = (x + tmpN - 1) >> 1;
                while (x != 0) {
                    tree[x] = Math.min(tree[2 * x], tree[2 * x + 1]);
                    x >>= 1;
                }
            }
        }
    }
}
