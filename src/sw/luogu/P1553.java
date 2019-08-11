package sw.luogu;

import java.util.Scanner;
import java.util.Stack;

public class P1553 {
    private static Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ac = sc.next().toCharArray();
        for (char c : ac) {
            if (c - '0' < 0) {
                print();
                System.out.print(c);
            } else {
                if (stack.size() > 0 || c != '0') stack.add(c);
            }
        }
        print();
    }

    private static void print() {
        int a = stack.size();
        if (a > 0) {
            char[] cc = new char[a];
            int i = 0;
            while (!stack.isEmpty()) {
                cc[i++] = stack.pop();
            }
            long l = Long.parseLong(new String(cc));
            System.out.print(l);
        }
    }

}
