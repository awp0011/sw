package sw.luogu;

import java.util.Scanner;
import java.util.Stack;

public class P1553 {
    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ac = sc.next().toCharArray();
        boolean cnt = true;
        for (char c : ac) {
            if (c - '0' < 0) {
                print();
                System.out.print(c);
                if (c == '%') cnt = false;
            } else {
                if (stack.size() > 0 || c != '0') stack.add(c);
            }
        }
        if (cnt) print();
    }

    private static void print() {
        boolean out0 = false;
        if (stack.isEmpty()) System.out.print('0');
        while (!stack.isEmpty()) {
            if (out0 || !stack.peek().equals('0')) {
                System.out.print(stack.pop());
                out0 = true;
            } else {
                stack.pop();
            }

        }
    }
}
