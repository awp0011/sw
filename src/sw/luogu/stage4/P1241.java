package sw.luogu.stage4;
/*
*        System.out.println((int)'(');//40
        System.out.println((int)')');//41
        System.out.println((int)'[');//91
        System.out.println((int)']');//93
* */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class P1241 {
    private static char[] src;
    private static boolean[] mat;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        src = br.readLine().toCharArray();
        mat = new boolean[src.length];
        for (int i = src.length - 1; i >= 0; i--) {
            if (src[i] == ')') {
                mat[i] = find('(', i - 1);
            } else if (src[i] == ']') {
                mat[i] = find('[', i - 1);
            }
        }
        for (int i = 0; i < src.length; i++) {
            if (mat[i]) System.out.print(src[i]);
            else {
                if (src[i] == ')' || src[i] == '(') System.out.print("()");
                else System.out.print("[]");
            }
        }
        System.out.println();
    }

    static boolean find(char t, int s) {
        for (int i = s; i >= 0; i--) {
            if (src[i] == t && !mat[i]) return mat[i] = true;
        }
        return false;
    }
}
