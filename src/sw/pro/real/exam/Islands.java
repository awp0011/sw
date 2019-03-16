package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class Islands {
    private static final int OFFSET = 10000;
    private static int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][][] map = new int[503][503][2];
    private static int N, M, Q, P;
    private static Map<Integer, ArrayDeque<Integer>> islands = new HashMap<>();
    private static Map<Integer, ArrayDeque<Integer>> adding = new HashMap<>();
    private static StringBuilder ans = new StringBuilder();
    private static HashSet<Integer> existed = new HashSet<>();
    private static ArrayDeque<Integer> commands = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            readTC(br);
            init();
            execute();
            System.out.println("#t" + ans.toString());
            clean();
        }
    }

    private static void execute() {
        Integer prev = 0;
        while (!commands.isEmpty()) {
            Integer c = commands.pollLast();
            if (!c.equals(prev)) {
                for (int is : islands.get(c)) {
                    int x = is / OFFSET;
                    int y = is % OFFSET;
                    map[x][y][0] = 1;
                    P++;
                    join(x, y, is);
                }
            }
            prev = c;
            ans.append(P).append(' ');
        }
    }

    private static void init() {
        P = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j][0] = 0;
                map[i][j][1] = i * OFFSET + j;
            }
        }
        for (ArrayDeque<Integer> set : islands.values()) {
            for (int is : set) {
                int x = is / OFFSET;
                int y = is % OFFSET;
                map[x][y][0] = 1;
                P++;
                join(x, y, is);
            }
        }
        ans.append(P).append(' ');
    }

    private static void join(int x, int y, int index) {
        for (int[] next : steps) {
            if (map[x + next[0]][y + next[1]][0] == 1)
                union(x, y, index, (x + next[0]), (y + next[1]), map[x + next[0]][y + next[1]][1]);
        }
    }

    private static int find(int x, int y, int index) {
        if (map[x][y][1] == index) return index;
        return map[x][y][1] = find(map[x][y][1] / OFFSET, map[x][y][1] % OFFSET, map[x][y][1]);
    }

    private static void union(int x1, int y1, int index1, int x2, int y2, int index2) {
        int p1 = find(x1, y1, index1);
        int p2 = find(x2, y2, index2);
        if (p1 == p2) return;
        P--;
        map[p2 / OFFSET][p2 % OFFSET][1] = map[p1 / OFFSET][p1 % OFFSET][1];
    }

    private static void readTC(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                islands.computeIfAbsent(valueOf(st.nextToken()), v -> new ArrayDeque<>()).add(i * OFFSET + j);
            }
        }
        Q = parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            Integer c = valueOf(st.nextToken());
            if (existed.contains(c)) {
                commands.addFirst(commands.peekFirst());
            } else {
                commands.addFirst(c);
                adding.put(c, islands.remove(c));
            }
        }

    }

    private static void clean() {
        ans.setLength(0);//效率较高的一种StringBuilder归零的方式

        //清理Map
        for (ArrayDeque<Integer> island : islands.values()) {
            island.clear();
        }
        existed.clear();
    }
}
