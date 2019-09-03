package sw.luogu.stage1;

import java.util.Scanner;

public class P1914 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int offset = sc.nextInt();
        char[] src = sc.next().toCharArray();
        for (int i = 0; i < src.length; i++) {
            int m = src[i] - 'a';
            m += offset;
            m %= 26;
            src[i] = (char) ('a'+m);
        }
        System.out.println(new String(src));
    }
}
