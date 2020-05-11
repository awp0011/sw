package sw.pro.road.pavement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Reference {
    private static int N;
    private static int M;
    private static final int[] r = new int[355];
    private static int diff;
    private static final int[] checkE = new int[70000];
    private static final int[][] E = new int[70000][3];

    static class Comp implements Comparator<int[]> {
        public int compare(int[] o1, int[] o2) {
            return o1[2] - o2[2];
        }
    }

    private static int grp(int node) {
        if (r[node] == node) return node;
        return r[node] = grp(r[node]);
    }

    private static void join(int a, int b) {
        r[grp(a)] = grp(b);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int test_case = 1; test_case <= T; ++test_case) {
            N = Integer.parseInt(br.readLine().trim());
            M = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < M; i++) {
                String[] line = br.readLine().trim().split(" ");
                E[i][0] = Integer.parseInt(line[0]);
                E[i][1] = Integer.parseInt(line[1]);
                E[i][2] = Integer.parseInt(line[2]);
            }
            Arrays.sort(E, 0, M, new Comp());
            for (int i = 0; i < M; i++) {
                checkE[i] = 0;
            }
            diff = 1987654321;
            int count = 0;
            for (int n = 1; n <= N; n++) {
                r[n] = n;
            }
            //最小生成树
            for (int j = 0; j < M; j++) {
                if (grp(E[j][0]) != grp(E[j][1])) {
                    join(E[j][0], E[j][1]);
                    checkE[j] = 1;
                    count++;
                    if (E[j][2] - E[0][2] >= diff) break;
                    if (count == N - 1) {
                        if (diff > E[j][2] - E[0][2]) diff = E[j][2] - E[0][2];
                        break;
                    }
                }
            }
            for (int s = 0; s <= M - N; s++) {
                if (checkE[s] == 0) continue;
                int min = -1, max = -1;
                checkE[s] = 0;
                count--;
                for (int n = 1; n <= N; n++) {
                    r[n] = n;
                }
                for (int j = s + 1; j < M; j++) {
                    if (checkE[j] == 1) {
                        if (min == -1) min = j;
                        if (j > max) max = j;
                        join(E[j][0], E[j][1]);
                    }
                }
                for (int j = s + 1; j < M; j++) {
                    if (checkE[j] == 0 && grp(E[j][0]) != grp(E[j][1])) {
                        join(E[j][0], E[j][1]);
                        checkE[j] = 1;
                        count++; // must be n-1
                        if (j < min) min = j;
                        if (j > max) max = j;
                        if (E[max][2] - E[min][2] < diff) diff = E[max][2] - E[min][2];
                        break;
                    }
                }
                if (count != N - 1) break;
            }
            System.out.printf("#%d %d\n", test_case, diff);
        }
    }
}
