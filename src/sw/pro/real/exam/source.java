package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class source {
    static int N, M, K;
    static int[] orders = new int[100_000];
    static int[] islands_cnt = new int[100_001];
    static Cell[][] islands = new Cell[500][500];
    static Map<Integer, ArrayList<Cell>> online_islands = new HashMap<>();
    static Map<Integer, ArrayList<Cell>> offline_islands = new HashMap<>();

    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedReader br = new BufferedReader(
                new FileReader(new File("/home/michael/IdeaProjects/Testcase/islands.tc")));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            readTestcase(br);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (islands[i][j].online) {
                        System.out.print(islands[i][j].name + ",");
                    } else {
                        System.out.print("0,");
                    }
                }
                System.out.println();
            }
            //clear
            online_islands.values().forEach(list -> list.clear());
            offline_islands.clear();

        }

    }

    static void readTestcase(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            orders[i] = Integer.parseInt(st.nextToken());
        }
        int order = 0;
        ArrayList<Cell> cellSet;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                order = Integer.parseInt(st.nextToken());
                //init each cell
                if (islands[i][j] == null) {
                    islands[i][j] = new Cell(i, j, order);
                } else {
                    islands[i][j].init(i, j, order);
                }
                //add each cell to online map
                cellSet = online_islands.get(order);
                if (cellSet == null) {
                    cellSet = new ArrayList<>();
                    online_islands.put(order, cellSet);
                }
                cellSet.add(islands[i][j]);
            }
        }
        //move order cell to offline
        for (int i = 0; i < K; i++) {
            cellSet = online_islands.get(orders[i]);
            for (Cell c : cellSet) {
                c.online = false;
            }
            offline_islands.put(orders[i], cellSet);
        }

    }

    static class Cell {
        int index, X, Y, name;
        boolean online;
        Cell parent;

        public Cell(final int x, final int y, final int n) {
            init(x, y, n);
        }

        void init(final int x, final int y, final int n) {
            index = x * N + y;
            X = x;
            Y = y;
            name = n;
            parent = this;
            online = true;
        }
    }
}
