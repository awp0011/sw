package sw.contest.vjudge.POJ2255;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    private static final ArrayDeque<String> stack = new ArrayDeque<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            String[] orders = br.readLine().split(" ");
            rebuild(orders[0], orders[1]);
            while (!stack.isEmpty()) {
                System.out.print(stack.pollFirst());
            }

            System.out.println();
        }
        while (br.ready());
    }

    private static void rebuild(String preorder, String inorder) {
        if (preorder.length() == 0 || inorder.length() == 0) return;
        if (preorder.length() == 1) stack.addFirst(preorder);
        else {
            int next = inorder.indexOf(preorder.charAt(0));
            rebuild(preorder.substring(0, 1), preorder.substring(0, 1));//root
            rebuild(preorder.substring(next + 1), inorder.substring(next + 1));//right subTree
            rebuild(preorder.substring(1, next + 1), inorder.substring(0, next));//left subTree
        }
    }
}
