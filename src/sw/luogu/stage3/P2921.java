package sw.luogu.stage3;

import java.io.*;
import java.util.ArrayDeque;

public class P2921 {
    private static int[] path, dp, vis;
private static ArrayDeque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Downloads\\testdata.in-1.txt"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int N = (int) in.nval;
        path = new int[N + 1];
        dp = new int[N + 1];
        vis = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            in.nextToken();
            path[i] = (int) in.nval;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= N; i++) ans.append(dfs(i, i)).append('\n');
        System.out.print(ans.toString());
    }

    private static int dfs(int n, int ft) {
        deque.add(n);
        while (!deque.isEmpty()){
            if (dp[n] > 0) return 1+dp[n];
            if (vis[n] == ft) return 0;
            vis[n] = ft;
            return dp[n] = 1 + dfs(path[n], ft);
        }
return 0;
    }
}
