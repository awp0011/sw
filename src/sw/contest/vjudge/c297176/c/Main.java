package sw.contest.vjudge.c297176.c;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Main {
    private static final Subnet[] nets = new Subnet[9];
    private static final int[][] Nodes = new int[1003][5];
    private static final PriorityQueue<Npath> queue = new PriorityQueue<>(Comparator.comparingInt(Npath::getLen));
    private static final ArrayDeque<Npath> used = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        br.readLine();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken());
            int M = parseInt(st.nextToken());
            for (int i = 1; i <= M; i++) {
                if (nets[i] == null) nets[i] = new Subnet();
                else nets[i].init();
                st = new StringTokenizer(br.readLine());
                int j = parseInt(st.nextToken());
                nets[i].value = parseInt(st.nextToken());
                for (int k = 0; k < j; k++) {
                    nets[i].nodes.add(parseInt(st.nextToken()));
                }
            }

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                Nodes[i][0] = parseInt(st.nextToken());
                Nodes[i][1] = parseInt(st.nextToken());

            }
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    Npath p = new Npath(i, j);
                    p.setLen(Nodes[i], Nodes[j]);
                    queue.add(p);
                }
            }

            int loop = (int) Math.pow(2, M);
            int fee = Integer.MAX_VALUE >> 1;
            while (--loop >= 0) {
                int cnt = 0;
                for (int i = 1; i <= N; i++) {
                    Nodes[i][2] = i;//parent
                    Nodes[i][3] = 1;//count node
                    Nodes[i][4] = 0;//is visited
                }
                for (int i = 0; i < M; i++) {
                    if (1 == ((loop >> i) & 1)) {
                        joinSubnet(i + 1);
                        cnt += nets[i + 1].value;
                    }
                }
                //System.out.print(" [" + loop);
                while (Nodes[1][3] != N) {
                    Npath shortpath = queue.poll();
                    used.add(shortpath);
                    if (union(shortpath.n1, shortpath.n2)) cnt += shortpath.len;

                }
                //System.out.print("," + Nodes[1][3] + "," + cnt + "]");
                fee = fee > cnt ? cnt : fee;
                if (used.size() > 0) queue.addAll(used);
                used.clear();
            }

            System.out.println(fee);
            if(t!=T)System.out.println(br.readLine());
            queue.clear();

        }

    }

    private static void joinSubnet(int index) {
        Nodes[nets[index].nodes.get(0)][4] = 1;
        for (int i = 1; i < nets[index].nodes.size(); i++) {
            union(nets[index].nodes.get(0), nets[index].nodes.get(i));
            Nodes[nets[index].nodes.get(i)][4] = 1;
        }
    }

    private static int find(int c) {
        if (Nodes[c][2] == c) return c;
        return Nodes[c][2] = find(Nodes[c][2]);
    }

    private static boolean union(int p, int q) {
        int c1 = find(p);
        int c2 = find(q);
        if (c1 == c2) return false;
        if (c1 < c2) {
            Nodes[c2][2] = Nodes[c1][2];
            Nodes[c1][3] += Nodes[c2][3];
        } else {
            Nodes[c1][2] = Nodes[c2][2];
            Nodes[c2][3] += Nodes[c1][3];
        }
        return true;
    }

    private static class Npath {
        int n1, n2;
        int len;

        Npath(int x, int y) {
            n1 = x;
            n2 = y;
        }

        void setLen(int[] x, int[] y) {
            len = (int) Math.pow(Math.abs(x[0] - y[0]), 2) + (int) Math.pow(Math.abs(x[1] - y[1]), 2);
        }

        int getLen() {
            return len;
        }
    }

    private static class Subnet {
        int value;
        ArrayList<Integer> nodes;

        Subnet() {
            nodes = new ArrayList<>();
        }

        void init() {
            nodes.clear();
        }
    }
}