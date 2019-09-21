package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1309 {
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata (3).in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        long[][] wins = new long[N][3];
        long[][] loss = new long[N][3];
        in.nextToken();
        int R = (int) in.nval;
        in.nextToken();
        int Q = (int) in.nval;
        N <<= 1;
        long[][] players = new long[N][3];

        for (int i = 0; i < N; i++) {
            players[i][0] = i + 1;
            in.nextToken();
            players[i][1] = (int) in.nval;//初始值
        }
        for (int i = 0; i < N; i++) {
            in.nextToken();
            players[i][2] = (int) in.nval;//能力值

        }
        sort(players);
        for (int ii = 0; ii < R; ii++) {
            int wpos = 0;
            int lpos = 0;
            for (int i = 0; i < N; i += 2) {
                if (players[i][2] > players[i + 1][2]) {
                    players[i][1]++;
                    wins[wpos++] = players[i];
                    loss[lpos++] = players[i + 1];
                } else {
                    players[i + 1][1]++;
                    wins[wpos++] = players[i + 1];
                    loss[lpos++] = players[i];
                }
            }
            merger(players, wins, loss);
        }

        System.out.println(players[Q - 1][0]);
    }

    private static void sort(long[][] arr) {
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int)(o2[1] == o1[1] ?  (o1[0] - o2[0]) :  (o2[1] - o1[1]));
            }
        });
    }

    private static void merger(long[][] tar, long[][] arr1, long[][] arr2) {
        int wpos = 0;
        int lpos = 0;
        int index = 0;
        while (wpos < arr1.length && lpos < arr2.length) {
            if (compare(arr1[wpos], arr2[lpos]) < 0) tar[index++] = arr1[wpos++];
            else tar[index++] = arr2[lpos++];

        }
        while (wpos < arr1.length) tar[index++] = arr1[wpos++];
        while (lpos < arr2.length) tar[index++] = arr2[lpos++];
    }

    private static long compare(long[] o1, long[] o2) {
        return o2[1] == o1[1] ?  (o1[0] - o2[0]) :  (o2[1] - o1[1]);
    }
}
