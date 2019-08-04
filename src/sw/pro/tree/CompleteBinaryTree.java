package sw.pro.tree;

import java.util.Scanner;

public class CompleteBinaryTree {
    private static int N;
    private static final int[] tree = new int[100003];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            tree[i] = sc.nextInt();
        }
        inOrder(1);
        System.out.println();
        sc.close();
    }

    private static void inOrder(int i) {
        if (i * 2 <= N) inOrder(i * 2);
        System.out.print(tree[i]);
        System.out.print(' ');
        if (((i * 2) + 1) <= N) inOrder((i * 2) + 1);
    }
}
