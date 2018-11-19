package sw.pro.road.pavement;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class MST {
    private static final int[] parents = new int[355];
    private static final int[][] edges = new int[70000][3];
    private static final int[] isVisited = new int[70000];

    private static int find(int n) {
        if (parents[n] == n) return n;
        return parents[n] = find(parents[n]);
    }

    private static void join(int a, int b) {
        parents[find(a)] = find(b);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st;
            int diff = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                edges[j][0] = Integer.parseInt(st.nextToken());
                edges[j][1] = Integer.parseInt(st.nextToken());
                edges[j][2] = Integer.parseInt(st.nextToken());

            }
            Arrays.sort(edges, 0, M, Comparator.comparing(o -> o[2]));
            //Arrays.fill(parents, 0, N, -1);
            for (int j = 1; j <=N ; j++) {
                parents[j]=j;
            }
            int joinCnt = 1;//
            for (int j = 0; j < M; j++) {// build MST
                if (find(edges[j][0]) != find(edges[j][1])) {
                    join(edges[j][0], edges[j][1]);
                    isVisited[j] = 1;
                    joinCnt++;
                }
                if (joinCnt == N) {
                    diff = edges[j][2] - edges[0][2];
                    break;
                }
            }
            int max, min;

            for (int j = 0; j <= M - N; j++) {
                //去掉将当前最小边
                if (isVisited[j] == 0) continue;
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                isVisited[j] = 0;
                joinCnt--;
                for (int s = 1; s <=N ; s++) {
                    parents[s]=s;
                }

                //出去最小后将由于的（N-2）在并查集在一起
                for (int k = j + 1; k < M; k++) {
                    if (isVisited[k] == 1) {
                        join(edges[k][0], edges[k][1]);
                        max = Math.max(max, edges[k][2]);
                        min = Math.min(min, edges[k][2]);
                    }
                }
                for (int k = j + 1; k < M; k++) {//增加一条新边，也就是当前最长边
                    if (isVisited[k] == 0 && find(edges[k][0]) != find(edges[k][1])) {
                        isVisited[k] = 1;
                        join(edges[k][0], edges[k][1]);
                        joinCnt++;
                        max = Math.max(max, edges[k][2]);
                        min = Math.min(min, edges[k][2]);
                        diff = Math.min(diff, max - min);
                        break;
                    }
                }
                if (joinCnt != N) break;//不能再形成生成树

            }
            System.out.println("#" + i + " " + diff);
            Arrays.fill(isVisited, 0, M, 0);
        }
        //System.out.println("#" + i + " " + (max - min));

    }
}



