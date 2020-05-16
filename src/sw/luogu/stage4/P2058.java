package sw.luogu.stage4;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class P2058 {
    private static final HashMap<Integer, Integer> sum = new HashMap<>();
    private static final int H24 = 86400;
    private static final StringBuilder ans = new StringBuilder();
    private static final HashSet<Integer> cnt = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("E:\\BaiduNetdiskDownload\\P2058_7.in"));
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        Node[] nodes = new Node[n];
        int left = 0, m, c;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            nodes[i] = new Node((int) in.nval);
            in.nextToken();
            m = (int) in.nval;
            for (int j = 0; j < m; j++) {
                in.nextToken();
                c = (int) in.nval;
                nodes[i].map.put(c, nodes[i].map.getOrDefault(c, 0) + 1);
                cnt.add(c);
            }
            nodes[i].map.forEach((k, v) -> {
                sum.put(k, sum.getOrDefault(k, 0) + v);
            });
            while (nodes[i].arrTime - nodes[left].arrTime >= H24) {
                nodes[left].map.forEach((k, v) -> {
                    sum.put(k, sum.getOrDefault(k, 0) - v);
                    if (sum.get(k) == 0) cnt.remove(k);
                });
                left++;
            }
            ans.append(cnt.size()).append('\n');
        }
        System.out.println(ans.toString());
    }

    static class Node {
        int arrTime;
        HashMap<Integer, Integer> map;

        Node(int n) {
            arrTime = n;
            map = new HashMap<>();
        }
    }
}