package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class P1280 {
    private static int N;
    private static Task[] tasks;

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval + 1;
        in.nextToken();
        int K = (int) in.nval;
        tasks = new Task[N + 1];

        for (int i = 0; i < K; i++) {
            in.nextToken();
            int from = (int) in.nval;
            in.nextToken();
            int to = (int) in.nval;
            if (tasks[from] == null) tasks[from] = new Task(from);
            tasks[from].ADJ.add(new Task(Math.min(from + to, N), to));
        }
        for (int i = 1; i <= N; i++) {
            if (tasks[i] == null) {
                tasks[i] = new Task(i);
                tasks[i].ADJ.add(new Task(i + 1, 0));
            }
        }
        dijkstra();
        System.out.println(N - tasks[N].len - 1);

    }

    private static void dijkstra() {
        PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.len));
        tasks[1].isVisited = true;
        tasks[1].len = 0;
        pq.add(tasks[1]);

        while (!pq.isEmpty()) {
            Task cur = pq.poll();
            for (Task next : cur.ADJ) {
                if (next.index > N) continue;
                int l = cur.len + next.len;
                if (tasks[next.index].len > l) {
                    tasks[next.index].len = l;
                    pq.add(tasks[next.index]);
                }
            }
        }
    }

    private static class Task {
        final int index;
        int len;
        boolean isVisited = false;
        ArrayList<Task> ADJ;

        Task(int i) {
            index = i;
            len = Integer.MAX_VALUE >> 1;
            ADJ = new ArrayList<>();
        }

        Task(int i, int l) {
            index = i;
            len = l;
        }
    }
}
