package sw.luogu.stage1;

import java.util.Scanner;

public class P1200 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] alias = sc.next().toCharArray();
        char[] cell = sc.next().toCharArray();
        int a = 1, c = 1;
        for (int i = 0; i < alias.length; i++) a *= alias[i] - '@';
        for (int i = 0; i < cell.length; i++) c *= cell[i] - '@';
        if ((a % 47) == (c % 47)) System.out.println("GO");
        else System.out.println("STAY");
    }
}
