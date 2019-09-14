package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1908 {
    private static int[][] arr;
    private static long[] tree;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("E:\\BaiduNetdiskDownload\\testdata.in"));
        long start = System.currentTimeMillis();
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int offset = 1;
        for (; offset <= n; offset *= 2) ;
        tree = new long[offset + n];
        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i][0] = (int) in.nval;
            arr[i][1] = i;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o2[0] - o1[0];
            }
        });
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int cnt = query(offset, offset + arr[i][1]);
            //System.out.println(arr[i][0] + " -> " + cnt);
            ans += cnt;
            update(offset + arr[i][1], 1);
        }
        System.out.println(ans);
        System.out.println("Time:"+(System.currentTimeMillis()-start));
    }

    private static int query(int s, int e) {
        int sum = 0;
        while (s <= e) {
            if (s % 2 == 1) sum += tree[s];
            if (e % 2 == 0) sum += tree[e];
            s = (s + 1) >> 1;
            e = (e - 1) >> 1;
        }
        return sum;
    }

    private static void update(int s, int diff) {
        while (s > 0) {
            tree[s] += diff;
            s >>= 1;
        }
    }
}
