package sw.luogu.stage2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class P1540 {
    private static ArrayDeque<Integer> queue = new ArrayDeque<>();
    private static HashSet<Integer> inQueue = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            int next = sc.nextInt();
            if (!inQueue.contains(next)) {
                ans++;
                if (inQueue.size() > M) {
                    inQueue.remove(queue.pollFirst());
                }
                inQueue.add(next);
                queue.add(next);
            }

        }
        System.out.println(ans);
    }
}
