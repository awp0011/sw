package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

public class Islands {
    private static final int OFFSET = 10000;
    private static final Integer RPT = 0;
    private static final int[][] steps = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static final int[][][] map = new int[6][6][2];
    private static int N;
    private static int M;
    private static int P;
    private static final Map<Integer, ArrayDeque<Integer>> islands = new HashMap<>();
    private static final Map<Integer, ArrayDeque<Integer>> adding = new HashMap<>();
    private static final StringBuilder ans = new StringBuilder();
    private static final HashSet<Integer> existed = new HashSet<>();
    private static final ArrayDeque<Integer> commands = new ArrayDeque<>();
    private static final ArrayDeque<Integer> result = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            readTC(br);
            init();
            execute();
            while (!result.isEmpty()) ans.append(' ').append(result.pollFirst());
            System.out.println("#" + t + ans.toString());
            clean();
        }
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
        int q = parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) {
            Integer c = valueOf(st.nextToken());
            if (existed.contains(c)) {
                commands.addFirst(RPT);//表示重复命令
            } else {
                commands.addFirst(c);
                existed.add(c);
                adding.put(c, islands.remove(c));
            }
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
        result.add(P);
    }

    private static void execute() {
        while (commands.size() > 1) {
            Integer c = commands.pollFirst();
            if (!RPT.equals(c)) {
                for (int is : adding.get(c)) {
                    int x = is / OFFSET;
                    int y = is % OFFSET;
                    map[x][y][0] = 1;
                    P++;
                    join(x, y, is);
                }
            }
            result.addFirst(P);
        }
    }

    private static void join(int x, int y, int index) {
        int i, j;
        for (int[] next : steps) {
            i = x + next[0];
            j = y + next[1];
            if (i >= 0 && i < N && j >= 0 && j < M && map[i][j][0] == 1) union(index, map[i][j][1]);
        }
    }

    private static void union(int index1, int index2) {
        int p1 = find(index1);
        int p2 = find(index2);
        if (p1 == p2) return;
        P--;
        if (p1 < p2) map[p2 / OFFSET][p2 % OFFSET][1] = map[p1 / OFFSET][p1 % OFFSET][1];
        else map[p1 / OFFSET][p1 % OFFSET][1] = map[p2 / OFFSET][p2 % OFFSET][1];
    }

    private static int find(int index) {
        int x = index / OFFSET;
        int y = index % OFFSET;
        if (map[x][y][1] == index) return index;
        return map[x][y][1] = find(map[x][y][1]);
    }

    private static void clean() {
        ans.setLength(0);//效率较高的一种StringBuilder归零的方式
        adding.clear();
        commands.clear();
        //清理Map
        for (ArrayDeque<Integer> island : islands.values()) {
            island.clear();
        }
        existed.clear();
    }
}
