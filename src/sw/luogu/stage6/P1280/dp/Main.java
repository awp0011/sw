package sw.luogu.stage6.P1280.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    private static StreamTokenizer in;

    private static int nextInt() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int n = nextInt();
        int k = nextInt();
        int[] f = new int[n + 3];
        ArrayList<LinkedList<Integer>> W = new ArrayList<>();
        for (int i = 0; i <= n; i++) W.add(new LinkedList<>());
        //桶式排序
        for (int i = 0; i < k; i++) W.get(nextInt()).add(nextInt());

        //倒着求最大空闲值
        for (int i = n; i > 0; i--) {
            if (W.get(i).isEmpty()) f[i] = f[i + 1] + 1;//时刻i 没有任务
            else for (int t : W.get(i)) f[i] = Math.max(f[i], f[i + t]);
        }
        System.out.println(f[1]);
    }
}
