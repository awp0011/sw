package sw.contest.vjudge.c297176.d;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    private static final int[][] map = new int[25][25];
    private static final int[] parent = new int[25];
    private static final Map<String, Integer> Name2ID = new HashMap<>();
    private static final Map<Integer, String> ID2Name = new HashMap<>();
    private static final Map<Integer, ArrayList<Integer>> cycles = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());
            if (n == 0 && m == 0) break;
            for (int i = 0; i < 25; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < 25; i++) {
                Arrays.fill(map[i], 0);
            }
            int index = 0;
            int n1, n2;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                String p1 = st.nextToken();
                if (Name2ID.containsKey(p1)) {
                    n1 = Name2ID.get(p1);
                } else {
                    n1 = index++;
                    Name2ID.put(p1, n1);
                    ID2Name.put(n1, p1);
                }
                String p2 = st.nextToken();
                if (Name2ID.containsKey(p2)) {
                    n2 = Name2ID.get(p2);
                } else {
                    n2 = index++;
                    Name2ID.put(p2, n2);
                    ID2Name.put(n2, p2);
                }
                map[n1][n2] = 1;
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    if (i == k) continue;
                    if (map[i][k] == 0) continue;
                    for (int j = 0; j < n; j++) {
                        if (i == j) continue;
                        if (k == j) continue;
                        if (map[k][j] == 0) continue;
                        if (map[i][j] == 0) map[i][j] = map[i][k] + map[k][j];
                        else map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (map[i][j] > 0 && map[j][i] > 0) join(i, j);
                }
            }
            for (int i = 0; i < n; i++) {
                cycles.computeIfAbsent(find(parent[i]), k -> new ArrayList<>()).add(i);
            }
            sb.append(String.format("Calling circles for data set %d:\n", t));
            for (ArrayList<Integer> values : cycles.values()) {
                sb.append(ID2Name.get(values.get(0)));
                for (int i = 1; i < values.size(); i++) {
                    sb.append(", " ).append(ID2Name.get(values.get(i)));
                }
                sb.append('\n');
            }
            sb.append('\n');
            t++;


            Name2ID.clear();
            ID2Name.clear();
            cycles.clear();
        }
        System.out.println(sb.toString().substring(0,sb.length()-2));
    }

    private static int find(int c) {
        if (parent[c] == c) return c;
        return parent[c] = find(parent[c]);
    }

    private static void join(int c1, int c2) {
        int p1 = find(c1);
        int p2 = find(c2);
        if (p1 == p2) return;
        parent[p2] = parent[p1];
    }
}
