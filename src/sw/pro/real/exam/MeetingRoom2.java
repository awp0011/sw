package sw.pro.real.exam;


import java.io.*;
import java.util.*;

public class MeetingRoom2 {
    private static final HashMap<Integer, LinkedList<Integer>> meetings = new HashMap<>();
    private static final TreeSet<Integer> keys = new TreeSet<>();
    private static final Meeting[] m = new Meeting[3003];
    private static final long[] dp = new long[3003];
    private static StreamTokenizer in;

    private static void init() throws IOException {
        //System.setIn(new FileInputStream("eval_input.txt"));
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        m[0] = new Meeting();
        m[0].init(0, 0, 0, 0);
    }

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception {
        init();
        int T = nextInt();
        for (int t = 1; t <= T; t++) {
            int n = nextInt();
            for (int i = 1; i <= n; i++) {
                int s = nextInt();
                int e = nextInt();
                int v = nextInt();
                if (m[i] == null) m[i] = new Meeting();
                m[i].init(i, s, e, v);

                //按照 会议结束e 进行桶排序
                LinkedList<Integer> set = meetings.getOrDefault(e, new LinkedList<>());
                set.push(i);
                meetings.put(e, set);
            }
            Arrays.fill(dp, 0);
            keys.clear();
            keys.addAll(meetings.keySet());
            int idx = 1, tail1 = 0, tail2 = 0;
            long room1, room2, sum1, sum2;
            for (int E : keys) {
                LinkedList<Integer> queue = meetings.get(E);
                while (!queue.isEmpty()) {
                    Meeting cur = m[queue.poll()];

                    int p1 = find(tail1, cur.S);
                    room1 = m[p1].sum + cur.V;
                    sum1 = room1 + m[tail1].sum;

                    int p2 = find(tail2, cur.S);
                    room2 = m[p2].sum + cur.V;
                    sum2 = room2 + m[tail2].sum;
                    //安排到会议室1或者2中，最后的价值和最大
                    if (sum1 > dp[idx - 1] || sum2 > dp[idx - 1]) {
                        if (sum2 > sum1) {
                            dp[idx] = sum2;
                            cur.P = p2;
                            tail2 = cur.idx;
                            cur.sum = room2;
                        } else {
                            dp[idx] = sum1;
                            cur.P = p1;
                            tail1 = cur.idx;
                            cur.sum = room1;
                        }
                    } else {
                        dp[idx] = dp[idx - 1];
                    }
                    idx++;
                }
            }
            System.out.println("#" + t + " " + dp[n]);
        }
    }

    private static int find(int tail, int s) {
        int idx = tail;
        while (m[idx].E > s) idx = m[idx].P;
        return idx;
    }

    private static class Meeting {
        int S, E, V, idx, P;
        long sum;

        Meeting() {
        }

        void init(int id, int s, int e, int v) {
            S = s;
            E = e;
            V = v;
            idx = id;
            P = 0;
            sum = 0;
        }
    }
}
