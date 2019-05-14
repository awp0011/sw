package sw.contest.vjudge.POJ1363;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static final int[] inSeq = new int[1003];
    private static final ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        end:
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break end;
            String line;
            while (!(line = br.readLine()).startsWith("0")) {
                StringTokenizer st = new StringTokenizer(line);
                for (int i = 1; i <= N; i++) {
                    inSeq[i] = Integer.parseInt(st.nextToken());
                }
                int outSeq = 1;
                for (int i = 1; i <= N; i++) {
                    stack.push(i);
                    while (!stack.isEmpty() && stack.peek() == inSeq[outSeq]) {
                        stack.pop();
                        outSeq++;
                    }

                }

                if (stack.isEmpty()) System.out.println("Yes");
                else System.out.println("No");
                stack.clear();
            }
            System.out.println();

            Arrays.fill(inSeq, 0);
        }
    }
}
