package sw.luogu.stage5.P1958;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken();
        int a = (int) in.nval;
        in.nextToken();
        int b = (int) in.nval;
        long[][][] map = new long[b + 1][a + 1][2];
        map[1][1][0] = 1;
        in.nextToken();
        int n = (int) in.nval;
        for (int k = 0; k < n; k++) {
            in.nextToken();
            int i = (int) in.nval;
            in.nextToken();
            int j = (int) in.nval;
            map[j][i][0] = -1;
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{1, 1});
        while (!que.isEmpty()) {
            int[] box = que.poll();
            if (box[0] + 1 <= b) {
                if (map[box[0] + 1][box[1]][0] != -1) {
                    map[box[0] + 1][box[1]][0] += map[box[0]][box[1]][0];
                    if (map[box[0] + 1][box[1]][1] == 0) {
                        que.add(new int[]{box[0] + 1, box[1]});
                        map[box[0] + 1][box[1]][1] = 1;
                    }
                }
            }
            if (box[1] + 1 <= a) {
                if (map[box[0]][box[1] + 1][0] != -1) {
                    map[box[0]][box[1] + 1][0] += map[box[0]][box[1]][0];
                    if (map[box[0]][box[1] + 1][1] == 0)
                        que.add(new int[]{box[0], box[1] + 1});
                    map[box[0]][box[1] + 1][1] = 1;
                }
            }
        }
        System.out.println(map[b][a][0]);
    }
}
