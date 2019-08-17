package sw.luogu;

import java.util.Scanner;
import java.util.TreeSet;

public class P2089 {
    private static TreeSet<String> ret = new TreeSet<>();
    private static int[] chicken = new int[10];
    private static StringBuilder sb = new StringBuilder();
    private static int n,ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n > 30 || n < 10) System.out.println(0);
        else {
            assembly(0, 0);
            System.out.println(ans);
            System.out.println(sb.toString());
        }
    }

    private static void assembly(int total, int level) {
        if (level == 10) {
            if (total == n) {
                ans++;
                for (int i = 0; i < 10; i++) {
                    if (i != 9) sb.append(chicken[i]).append(' ');
                    else sb.append(chicken[i]).append('\n');
                }
            }
        } else {
            for (int i = 1; i <= 3; i++) {
                if (total + i > n) break;
                chicken[level] = i;
                assembly(total + i, level + 1);
            }
        }

    }
}
