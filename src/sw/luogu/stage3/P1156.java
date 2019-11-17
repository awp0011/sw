package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class P1156 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int D = (int) in.nval;
        in.nextToken();
        int G = (int) in.nval;
        int[][] food = new int[G + 3][3];

        int Ti = 10;
        for (int i = 0; i < G; i++) {
            in.nextToken();
            food[i][0] = (int) in.nval;
            in.nextToken();
            food[i][1] = (int) in.nval;
            in.nextToken();
            food[i][2] = (int) in.nval;
        }
        Arrays.sort(food, 0, G, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int i = 0;
        for (; i < G; i++) {
            if (Ti < food[i + 1][0]) Ti += food[i][1];
            else D -= food[i][2];
            if (D <= 0) break;
        }

        System.out.println(D <= 0 ? food[i][0] : Ti);
    }

}
