package sw.luogu.stage1;

import java.util.Scanner;
import java.util.Stack;

public class P1427 {
    private static final Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n!=0){
            stack.add(n);
            n = sc.nextInt();
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }
}
