package sw.luogu;

import java.util.Scanner;

public class P1598 {
    private static final int[] ap = new int[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ac;
        for (int i = 0; i < 4; i++) {
            ac = sc.nextLine().toCharArray();
            for (int j = 0; j < ac.length; j++) {
                int pos = ac[j] - 'A';
                if (pos >= 0) ap[pos]++;
            }
        }
        int height = 0;
        for (int i = 0; i < 26; i++) {
            if (ap[i] > height) height = ap[i];
        }
        while (height > 0) {
            for (int i = 0; i < 26; i++) {
                if (ap[i] >= height) System.out.print('*');
                else System.out.print(' ');
                if (i != 25) System.out.print(' ');
                else System.out.println();
            }
            height--;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print((char)(i+'A'));
            if (i != 25) System.out.print(' ');
            else System.out.println();
        }
    }
}
