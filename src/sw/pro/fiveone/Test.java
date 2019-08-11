package sw.pro.fiveone;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Test {
    private static long total;
    private static int min, start, end, pos;
    private static int[] minPos;
    private static int[] intValues = new int[32];
    private static final ArrayDeque<Integer> stock = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 32; i++) {
            intValues[i] = 1 << i;
        }
        System.setIn(new FileInputStream("C:\\workspace\\idea\\sw\\src\\sw\\pro\\fiveone\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            start = sc.nextInt();
            end = sc.nextInt();
            min = 0;
            getMin5Bit(start);
            total = 0;
            if (min > end) min = 0;
            else sum5bit();
            System.out.println("#" + t + " " + total + " " + min);
        }


    }

    private static void getMin5Bit(int a) {
        minPos = new int[]{0, 1, 2, 3, 4};
        if (a > 31) {
            int index = 0;
            while (a > 0) {
                if ((a & 1) == 1) stock.add(index++);
                else index++;
                a >>= 1;
            }
            index = 4;
            while (!stock.isEmpty() && index >= 0) {
                minPos[index--] = stock.pollLast();
            }
            if (stock.size() > 0) {
                next5bit();
                stock.clear();
            } else if (pos >= 0) {
                for (int i = 1; i < 5; i++) {
                    if (minPos[i] == minPos[i - 1]) minPos[i]++;
                }
                pos = firstZero();
            }
        }
        min = getInt();
    }

    private static void next5bit() {
        pos = firstZero();
        minPos[pos]++;
        init(pos);
    }

    private static int getInt() {
        int intValue = 0;
        for (int i = 0; i < 5; i++) {
            intValue += intValues[minPos[i]];
        }
        return intValue;
    }

    private static int firstZero() {
        int i = 0;
        for (; i < 4; i++) {
            if (minPos[i + 1] - minPos[i] > 1) break;
        }
        return i;
    }

    private static void init(int pos) {
        for (int i = pos - 1; i >= 0; i--) {
            minPos[i] = i;
        }
    }


    private static void sum5bit() {
        int next = 0;
        total = min;
        while (next <= end) {
            total += next;
            if (pos != 4 && minPos[pos + 1] - minPos[pos] > 1) {
                minPos[pos]++;
            } else {
                next5bit();
            }
            next = getInt();
        }
    }
}
