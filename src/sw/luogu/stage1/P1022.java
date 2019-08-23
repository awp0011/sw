package sw.luogu.stage1;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P1022 {
    private static int[] parts = new int[4];
    private static char X;
    private static Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] function = sc.next().split("=");
        proc(function[0].toCharArray(), 0);
        proc(function[1].toCharArray(), 1);
        parts[0] -= parts[2];
        parts[3] -= parts[1];

        double ans = (double) parts[0] / (double) parts[3];
        System.out.print(X);
        System.out.printf("=%.3f\n", ans);


    }

    //('a'));//97
    //('z'));//122
    //('0'));//48
    //('9'));//57
    //('-'));//45
    //('+'));//43
    private static void proc(char[] str, int lorR) {
        int offset = lorR == 0 ? 0 : 2;
        parts[offset] = 0;
        parts[offset + 1] = 0;
        int number = 0;
        int prevFlag = 1;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == '+') {
                if (!queue.isEmpty()) parts[offset] += prevFlag * number();
                prevFlag = 1;
            } else if (str[i] == '-') {
                if (!queue.isEmpty()) parts[offset] += prevFlag * number();
                prevFlag = -1;
            } else if (str[i] >= 97) {
                X = str[i];
                parts[offset + 1] += prevFlag * number();
                prevFlag = 1;
            } else {
                queue.add(str[i] - '0');
            }
        }
        if (!queue.isEmpty()) parts[offset] += prevFlag * number();

    }

    private static int number() {
        if (queue.isEmpty()) return 1;

        int sum = 0;
        while (!queue.isEmpty()) {
            sum *= 10;
            sum += queue.poll();
        }
        return sum;
    }


}
