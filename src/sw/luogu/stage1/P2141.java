package sw.luogu.stage1;

import java.util.HashSet;
import java.util.Scanner;

public class P2141 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] d = new int[len];
        HashSet<Integer> dc = new HashSet<>();
        for (int i = 0; i < len; i++) {
            d[i] = sc.nextInt();
            dc.add(d[i]);
        }
        HashSet<Integer> cnt = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int sum = d[i] + d[j];
                if (sum == d[i]) continue;
                if (sum == d[j]) continue;
                if (dc.contains(sum)) cnt.add(sum);
            }
        }
        System.out.println(cnt.size());
    }
}
