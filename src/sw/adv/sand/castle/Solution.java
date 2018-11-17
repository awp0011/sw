package sw.adv.sand.castle;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private static Castle[] kids = new Castle[12];
    private final static Queue<Castle> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long startTime = System.currentTimeMillis();
        StringTokenizer st;
        int A, B;
        for (int i = 0; i < 12; i++) {
            kids[i] = new Castle();
        }
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= N; i++) {
                kids[i].init();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                A = Integer.parseInt(st.nextToken());
                B = Integer.parseInt(st.nextToken());
                kids[B].taller.add(A);
                kids[A].inDepth += 1;
            }
            for (Castle c : kids) {
                if (c.inDepth == 0) {
                    c.height = 1;
                    queue.add(c);
                }
            }

            bfs();
            System.out.print("#");
            System.out.print(t);
            for (int i = 1; i <= N; i++) {
                System.out.print(' ');
                System.out.print(kids[i].height);
            }
            System.out.println();
        }


        long endTime = System.currentTimeMillis();
        //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static void bfs() {
        Castle zero;
        while (!queue.isEmpty()) {
            if (queue.peek() == null) break;
            zero = queue.poll();
            while (!zero.taller.isEmpty()) {
                if (zero.taller.peek() == null) break;
                int name = zero.taller.poll();
                kids[name].height = zero.height + 1;
                kids[name].inDepth--;
                if (kids[name].inDepth == 0) queue.add(kids[name]);
            }
        }
    }

    private static class Castle {
        int inDepth;
        int height;
        final LinkedList<Integer> taller;

        Castle() {
            taller = new LinkedList<>();
            init();

        }

        void init() {
            taller.clear();
            inDepth = 0;
            height = 0;
        }
    }
}
