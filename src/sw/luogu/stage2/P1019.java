package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.copyOfRange;

public class P1019 {
    private static final int[] used = new int[20];
    private static final ArrayList<char[]> words = new ArrayList<>();
    private static final int[][] map = new int[20][20];//>0表示可以相邻，且重合部分的长度
    private static int n, ans = 0;
    private static char start;
    // private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            words.add(in.sval.toCharArray());
        }
        in.nextToken();
        start = in.sval.charAt(0);
        for (int i = 0; i < n; i++) {
            char[] ci = words.get(i);
            for (int j = 0; j < n; j++) {
                char[] cj = words.get(j);
                int size = ci.length > cj.length ? cj.length : ci.length;
                for (int len = 1 ; len <size; len++) {
                    char[] subCI = copyOfRange(ci, ci.length - len, ci.length);
                    char[] subCJ = copyOfRange(cj, 0, len);
                    if (Arrays.equals(subCI, subCJ)) {
                        map[i][j] = len;
                        break;
                    }
                }
            }
        }
        find(0, 0);
        System.out.println(ans);
    }

    private static void find(int priv, int length) {
        if (length > ans) {
            ans = length;
            //System.out.println(sb.toString());
        }
        for (int i = 0; i < n; i++) {
            if (length == 0) {
                if (words.get(i)[0] == start) {
                    used[i]++;
                    //sb.append(words.get(i));
                    find(i, words.get(i).length);
                    //sb.setLength(0);
                    used[i]--;
                }
            } else {
                if (map[priv][i] > 0 && used[i] <= 1) {
                    used[i]++;
                    //sb.setLength(sb.length() - map[priv][i]);
                    //sb.append(words.get(i));
                    find(i, length + words.get(i).length - map[priv][i]);
                    //sb.setLength(sb.length() + map[priv][i] - words.get(i).length);
                    used[i]--;
                }
            }
        }
    }
}
