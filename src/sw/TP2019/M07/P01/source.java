package sw.TP2019.M07.P01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class source {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        Room[] rooms = new Room[N + 1];
        for (int i = 0; i <= N; i++) {
            rooms[i] = new Room(i);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            rooms[s].forward.add(new int[]{e, t});
            rooms[e].reverse.add(new int[]{s, t});
        }
        PriorityQueue<int[]> deque = new PriorityQueue<>(Comparator.comparingInt(e -> e[1]));
        dfs(X, rooms, 1, deque);
        dfs(X, rooms, 0, deque);
        int ans = Integer.MIN_VALUE;
        for (Room r : rooms) {
            if (r.fLength == Integer.MAX_VALUE) continue;
            if (r.rLength == Integer.MAX_VALUE) continue;
            int total = r.fLength + r.rLength;
            ans = ans < total ? total : ans;
        }
        System.out.println(ans);
    }

    private static void dfs(int start, Room[] rooms, int visitor, PriorityQueue<int[]> queue) {
        queue.offer(new int[]{start, 0});
        rooms[start].setLength(visitor, 0);
        while (!queue.isEmpty() && queue.peek() != null) {
            int[] current = queue.poll();
            if (rooms[current[0]].visited == visitor) continue;
            rooms[current[0]].visited = visitor;
            for (int[] next : rooms[current[0]].getNext(visitor)) {
                int length = rooms[current[0]].getLength(visitor) + next[1];
                if (rooms[next[0]].getLength(visitor) > length) rooms[next[0]].setLength(visitor, length);
                if (rooms[next[0]].visited != visitor)
                    queue.add(new int[]{next[0], length});
            }
        }


    }

    private static class Room {
        int name;
        int fLength, rLength;
        int visited;
        ArrayList<int[]> forward;
        ArrayList<int[]> reverse;

        Room(int n) {
            name = n;
            forward = new ArrayList<>();
            reverse = new ArrayList<>();
            fLength = Integer.MAX_VALUE;
            rLength = Integer.MAX_VALUE;
            visited = -1;
        }

        ArrayList<int[]> getNext(int d) {
            return d == 1 ? reverse : forward;
        }

        void setLength(int visitor, int length) {
            if (visitor == 1) rLength = length;
            else fLength = length;
        }

        int getLength(int visitor) {
            return visitor == 1 ? rLength : fLength;
        }
    }
}
