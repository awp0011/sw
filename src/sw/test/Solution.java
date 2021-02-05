package sw.test;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
// P0088
public class Solution {
    private static StreamTokenizer in;
    private static final int MAX = 100003;
    private static final int[] tree = new int[3 * MAX];
    private static final int[][] building = new int[MAX][3];//0:index; 1:Height; 2:P
    private static int N, offset;

    private static void init() throws IOException {
        //System.setIn(new FileInputStream(""));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        init();
        int T = nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = nextInt();
            offset = 1;
            while (offset < N) offset <<= 1;
            offset--;

            for (int i = 1; i <= N; i++) {
                building[i][0] = i;         //index
                building[i][1] = nextInt(); //height
            }
            for (int i = 1; i <= N; i++) {
                building[i][2] = nextInt(); //power
            }
            //building sort by Height(desc), Index(asc)
            Arrays.sort(building, 1, N + 1, (o1, o2) -> o1[1] == o2[1] ? (o1[0] - o2[0]) : (o2[1] - o1[1]));

            long sum = 0;
            for (int i = 1; i <= N; i++) {
                update(building[i][0]);
                int preSum = querySum(building[i][0]);
                int target = preSum + building[i][2] + 1;
                if (target > tree[1]) continue;
                int score = findNth(target);
                sum += score;
                System.out.println(building[i][0] + " " + score);
            }
            System.out.println("#" + tc + " " + sum);
        }
    }

    private static void update(int pos) {
        int idx = pos + offset;
        while (idx > 0) {
            tree[idx]++;
            idx >>= 1;
        }
    }

    private static int querySum(int pos) {
        int s = 1 + offset;
        int e = pos + offset;
        int sum = 0;
        while (s <= e) {
            if (s % 2 == 1) sum += tree[s];
            if (e % 2 == 0) sum += tree[e];
            s = (s + 1) >> 1;
            e = (e - 1) >> 1;
        }
        return sum;
    }

    private static int findNth(int target) {
        int pos = 1;
        while (pos <= offset) {
            int left = pos * 2;
            if (tree[left] < target) {
                target -= tree[left];
                pos = left + 1;
            } else {
                pos <<= 1;
            }
        }
        pos -= offset;
        if (pos <= N) return pos;
        return 0;
    }


}
