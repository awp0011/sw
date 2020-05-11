package sw.pro.e20200424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Solution {
    private static final long INF = Long.MAX_VALUE >> 1;
    private static final long[] distance = new long[1003];
    private static final int[] precursor = new int[1003];
    private static final int[][] edges = new int[8003][3];//3000*2 + 2000
    private static final HashMap<Integer, HashSet<Integer>> angles = new HashMap<>();
    private static int V, index;

    private static boolean bellman_Ford() {
        distance[0] = 0;
        for (int i = 0; i < V - 1; i++) {
            boolean noRelaxed = true;
            for (int j = 0; j < index; j++) {
                if (distance[edges[j][1]] > distance[edges[j][0]] + edges[j][2]) {//relaxed
                    distance[edges[j][1]] = distance[edges[j][0]] + edges[j][2];
                    precursor[edges[j][1]] = edges[j][0];
                    noRelaxed = false;
                }
            }
            if (noRelaxed) break;
        }

        for (int j = 0; j < index; j++) {
            if (distance[edges[j][1]] > distance[edges[j][0]] + edges[j][2]) return true;
        }
        return false;
    }

    private static int findPathCnt() {
        int cnt = 0;
        int root = V - 1;
        while (0 != root) {
            if (angles.get(root) != null && angles.get(root).contains(precursor[root])) cnt++;
            //System.out.print(root + "-->");
            root = precursor[root];
        }
        //System.out.println(root);
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = parseInt(st.nextToken());
            int E = parseInt(st.nextToken());
            int A = parseInt(st.nextToken());
            for (int i = 0; i < V; i++) {
                distance[i] = INF;
                precursor[i] = i;
            }
            index = 0;
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = parseInt(st.nextToken());
                int b = parseInt(st.nextToken());
                int c = parseInt(st.nextToken());
                edges[index][0] = a;
                edges[index][1] = b;
                edges[index++][2] = c;

                edges[index][0] = b;
                edges[index][1] = a;
                edges[index++][2] = c;

            }
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int a = parseInt(st.nextToken());
                int b = parseInt(st.nextToken());
                int c = parseInt(st.nextToken());
                edges[index][0] = a;
                edges[index][1] = b;
                edges[index++][2] = -c;
                angles.computeIfAbsent(b, k -> new HashSet<>()).add(a);
            }
            boolean hasBug = bellman_Ford();
            if (hasBug) System.out.println("#" + t + " BUG");
            else if (distance[V - 1] == INF) System.out.println("#" + t + " NO");
            else System.out.println("#" + t + " " + distance[V - 1] + " " + findPathCnt());
            for (HashSet<Integer> e : angles.values()) e.clear();
        }
    }


}
