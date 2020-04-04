package sw.luogu.stage4;

import java.util.Scanner;

public class P5705 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[] c = sc.nextLine().toCharArray();
        for (int i = c.length - 1; i >= 0; i--) System.out.print(c[i]);
        System.out.println();
    }

}
