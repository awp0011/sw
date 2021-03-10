package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;


/*
 * 1.建立边与点的对应关系，HashMap<Integer,int[2]> mapping,int[2]为两个端点
 * 2.简单并查集(点),MST时 需要使用 int[] nodeP
 * 3.带权并查集(互斥边)，建立互斥关系 int[] edgeP, int[] flag(并查集的权，0 1表示互斥关系)
 * 4.边权集合ArrayList<int[2]>，并进行升序排序，MST时 需要使用。int[2]为 [边序号，权值]
 * 5.二进制枚举或者dfs，遍历所有互斥边的使用或不使用情况
 * 6.MST 使用Kruskal算法实现，需要基于5的情况进行循环
 * */
public class SolutionP0042 {
    private static StreamTokenizer in;
    private static final int[] nodeP = new int[52];
    private static final int[] edgeP = new int[202];
    private static final int[] flag = new int[202];
    private static final boolean[] used = new boolean[202];//边 是否使用
    private static final HashMap<Integer, int[]> map = new HashMap<>();
    private static final int[][] w = new int[202][2];
    private static final ArrayList<int[]> sorted = new ArrayList<>();
    private static final ArrayList<Integer> parent = new ArrayList<>();
    private static final BitSet mutex = new BitSet();
    private static int N;

    private static void init() {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }

    private static int nextInt() throws Exception {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        init();
        int T = nextInt();
        for (int t = 1; t <= T; t++) {
            N = nextInt();
            int M = nextInt();
            int K = nextInt();
            for (int i = 1; i <= M; i++) {
                edgeP[i] = i;
                flag[i] = -1;
                used[i] = true;
                int a = nextInt();
                int b = nextInt();
                map.put(i, new int[]{a, b});
                w[i][0] = i;
                w[i][1] = nextInt();
                sorted.add(w[i]);
            }
            sorted.sort(Comparator.comparingInt(o -> o[2]));
            mutex.clear();
            for (int i = 0; i < K; i++) {
                int a = nextInt();
                int b = nextInt();
                unionEdge(a, b);
                mutex.set(a);
                mutex.set(b);
            }
            parent.clear();
            for (int i = 1; i < M; i++) {
                if (mutex.get(i) && findEdge(i) == i) {
                    parent.add(i);
                }
            }
            //二进制枚举
            int total = (int) Math.pow(2, parent.size());
            total--;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < total; i++) {
                int binary = i, idx = 0;
                while (binary > 0) {
                    used[parent.get(idx)] = ((binary ^ 1) == 0);
                    binary >>= 1;
                    idx++;
                }
                min = Math.min(min, MST());
            }
            if (min == Long.MAX_VALUE) min = -1;
            System.out.println("#" + t + " " + min);
            map.clear();
            sorted.clear();
        }
    }

    //Kruskal
    private static long MST() {
        long mst = 0;
        for (int i = 0; i < N; i++) nodeP[i] = i;
        int cnt = 0;

        for (int[] next : sorted) {
            int edge_idx = next[0];
            //互斥边是否使用判断
            int p = findEdge(edge_idx);
            if (p != edge_idx && flag[p] != flag[edge_idx] && used[p]) continue;


            int a = map.get(edge_idx)[0];
            int b = map.get(edge_idx)[1];
            if (unionNode(a, b)) {
                mst += next[1];
                cnt++;
                if (cnt == N - 1) break;
            }
        }

        if (cnt != N - 1) return Long.MAX_VALUE;
        return mst;
    }

    //带权并查集-find
    private static int findEdge(int c) {
        if (edgeP[c] == c) return c;
        int p = edgeP[c];
        edgeP[c] = findEdge(edgeP[c]);
        flag[c] = reverse(flag[p]);
        return edgeP[c];
    }

    //带权并查集-union
    private static void unionEdge(int c1, int c2) {
        int p1 = findEdge(c1);
        int p2 = findEdge(c2);
        if (p1 < p2) {
            edgeP[p2] = p1;
            if (flag[c1] == -1) flag[c1] = 0;
            if (flag[c2] == -1) flag[c2] = (flag[c1] + 1) % 2;
            if (flag[c1] == flag[c2]) {
                flag[c2] = reverse(flag[c1]);//c1 c2 互斥
                flag[p2] = reverse(flag[p2]);//自身反转
            }
        } else if (p1 > p2) {
            edgeP[p1] = p2;
            if (flag[c2] == -1) flag[c2] = 0;
            if (flag[c1] == -1) flag[c1] = (flag[c2] + 1) % 2;
            if (flag[c1] == flag[c2]) {
                flag[c1] = reverse(flag[c2]);//c1 c2 互斥
                flag[p1] = reverse(flag[p1]);//自身反转
            }
        }
    }

    //简单并查集-find
    private static int findNode(int c) {
        if (nodeP[c] == c) return c;
        return nodeP[c] = findNode(nodeP[c]);
    }

    //简单并查集-union
    private static boolean unionNode(int c1, int c2) {
        int p1 = findNode(c1);
        int p2 = findNode(c2);
        if (p1 == p2) return false;
        nodeP[p1] = p2;
        return true;
    }

    private static int reverse(int src) {
        return (src + 1) % 2;
    }
}
