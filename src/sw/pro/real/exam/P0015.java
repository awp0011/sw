package sw.pro.real.exam;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class P0015 {
    private static final int[][] map = new int[101][101];
    private static final StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    private static final PrintWriter out = new PrintWriter(System.out);
    private static final ArrayDeque<Integer> aDeque = new ArrayDeque<>();
    private static int N;

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        int T = nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = nextInt();
            int M = nextInt();
            int S = nextInt();
            for (int i = 1; i <= M; i++) map[nextInt()][nextInt()] = 1;
            out.print("#");
            out.print(tc);
            out.print(' ');
            dfs(S);
            out.println();
            bfs(S);
            for (int i = 1; i <= N; i++) {
                Arrays.fill(map[i], 0);
            }
        }
    }

    static void bfs(int s) {
        aDeque.add(s);
        while (!aDeque.isEmpty()){
            int cur = aDeque.pollFirst();
            print(cur);
            map[cur][0] = 1;
            for (int i = 1; i <= N; i++) {
                if (map[cur][i] == 1 && map[i][0] == 0) aDeque.addLast(i);
            }
        }
    }

    static void dfs(int s) {
        print(s);
        map[s][0] = 1;
        for (int i = 1; i <= N; i++) {
            if (map[s][i] == 1 && map[i][0] == 0) dfs(i);
        }
    }

    static void print(int s) {
        out.print(s);
        out.print(' ');
    }
}
