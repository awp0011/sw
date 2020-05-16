package sw.luogu.stage4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class P4387 {
    private static final Stack<Integer> stack = new Stack<>();
    private static final ArrayList<Integer> list1 = new ArrayList<>();
    private static final ArrayList<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) list1.add(j,parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) list2.add(j,parseInt(st.nextToken()));
            int next = 0;
            for (int j = 0; j < n; j++) {
                stack.push(list1.get(j));
                while (!stack.isEmpty() && list2.get(next).equals(stack.peek())) {
                    stack.pop();
                    next++;
                }
            }
            System.out.println(stack.isEmpty() ? "Yes" : "No");
            stack.clear();
        }
    }

}
