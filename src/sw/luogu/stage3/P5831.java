package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class P5831 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int K = (int) in.nval;
        in.nextToken();
        int N = (int) in.nval;
        int[] d = new int[N];
        HashMap<Integer, HashSet<Integer>> map1 = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> map2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            in.nextToken();
            d[i] = (int) in.nval;
            map1.put(d[i], new HashSet<>());
            map2.put(d[i], new HashSet<>());
            for (int j = i - 1; j >= 0; j--) {
                map1.get(d[i]).add(d[j]);
            }
        }
        int cnt = 0;
        for (HashSet<Integer> set : map1.values()) cnt += set.size();
        for (int i = 1; i < K; i++) {
            for (int j = 0; j < N; j++) {
                in.nextToken();
                d[j] = (int) in.nval;
                for (int k = j - 1; k >= 0; k--) {
                    if (!map1.get(d[j]).contains(d[k])) {
                        map2.get(d[k]).add(d[j]);
                    }
                }
            }
        }
        for (HashSet<Integer> set : map2.values()) cnt -= set.size();
        System.out.println(cnt);
    }
}
