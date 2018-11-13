package sw.adv.meet99;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
    private static Queue<Integer> queue = new LinkedList<>();
    private static Integer MEET99 = 99;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int min_cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            queue.add(Integer.parseInt(st.nextToken()));
            if (MEET99.equals(queue.peek())) {
                min_cnt = 1;
            } else {
                for (int i = 2; i <= N; i++) {
                    min_cnt = i;
                    if (meet(queue, Integer.valueOf(st.nextToken()))) break;
                    min_cnt = 0;
                }
            }
            System.out.println("#" + t + " " + min_cnt);
            queue.clear();

        }
    }

    private static boolean meet(Queue<Integer> q, Integer n) {
        boolean isMeet = false;
        int cnt = q.size();
        while (cnt != 0) {
            Integer current = q.peek() == null ? 0 : q.poll();
            Integer next = current + n;
            if (next.equals(MEET99)) {
                isMeet = true;
                break;
            }
            q.add(next);
            next = current - n;
            if (next.equals(MEET99)) {
                isMeet = true;
                break;
            }
            q.add(next);
            cnt--;
        }

        return isMeet;

    }
}