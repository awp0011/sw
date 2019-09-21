package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class P1449 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        char next = str.charAt(0);
        int mid = 0, pos = 1;
        while (next != '@') {
            if (Character.isDigit(next)) {
                mid *= 10;
                mid += next - '0';
            } else if ('.' == next) {
                stack.push(mid);
                mid = 0;
            } else if ('+' == next) {
                stack.push(stack.pop() + stack.pop());
            } else if ('-' == next) {
                int first = stack.pop();
                int end = stack.pop();
                stack.push(end - first);
            } else if ('*' == next) {
                stack.push(stack.pop() * stack.pop());
            } else if ('/' == next) {
                int first = stack.pop();
                int end = stack.pop();
                stack.push(end / first);
            }
            next = str.charAt(pos++);
        }
        System.out.println(stack.pop());
    }
}
