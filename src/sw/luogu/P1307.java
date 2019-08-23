package sw.luogu;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1307 {
    private static final ArrayDeque<Integer> qt = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] original = sc.next().toCharArray();
        if (original[0] == 45) System.out.print('-');
        else qt.add((int) original[0]);
        for (int i = 1; i < original.length; i++) qt.add((int) original[i]);
        int zero = '0';
        while (qt.peekLast() == zero) qt.pollLast();
        while (!qt.isEmpty()) System.out.print((char) qt.pollLast().intValue());
        System.out.println();
    }
}
