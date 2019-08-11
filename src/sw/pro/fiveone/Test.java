package sw.pro.fiveone;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Scanner;

public class Test {
    private static long total;
    private static int min, max;
    private static HashSet<Integer> all = new HashSet<>();
    private static int[] maxPos = new int[]{25, 26, 28, 29, 30};
    private static int[] minPos = new int[]{0, 1, 2, 3, 4};
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
            int a = sc.nextInt();
            int b = sc.nextInt();
            min = 0;
            max = 0;
            getMin5Bit(a);
            getMax5Bit(b);

            total = 0;

            for (int i = 4; i >= 0; i--) {
                int pix = 0;
                for (int j = 0; j < i; j++) {
                    pix += intValues[minPos[j]];
                }
                //find5bit(i, 4, pix, 32);
            }
            if (min > b) {
                min = 0;
                total = 0;
            }
            // System.out.println("#" + t + " " + max + " " + min);
            System.out.println("#" + t + " " + min + " " + max);
            all.clear();
        }


    }

    private static void getMin5Bit(int a) {
        minPos = new int[]{0, 1, 2, 3, 4};
        if (a > 31) {
            int pos = 0;
            while (a > 0) {
                if ((a & 1) == 1) stock.add(pos++);
                else pos++;
                a >>= 1;
            }
            pos = 4;
            while (!stock.isEmpty() && pos >= 0) {
                minPos[pos--] = stock.pollLast();
            }
            if (stock.size() > 0) {
                int p = firstZero(minPos);
                minPos[p]++;
                init(p, minPos);
                stock.clear();
            } else if (pos >= 0) {
                for (int i = 1; i < 5; i++) {
                    if (minPos[i] == minPos[i - 1]) minPos[i]++;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            min += intValues[minPos[i]];
        }
    }

    private static int firstZero(int[] arr) {
        int i = 0;
        for (; i < 4; i++) {
            if (arr[i + 1] - arr[i] > 1) break;
        }
        return i;
    }

    private static void init(int pos, int[] arr) {
        for (int i = pos - 1; i >= 0; i--) {
            arr[i] = i;
        }
    }

    private static void getMax5Bit(int a) {
        maxPos = new int[]{0, 1, 2, 3, 4};
        int pos = 0;
        while (a > 0) {
            if ((a & 1) == 1) stock.add(pos++);
            else pos++;
            a >>= 1;
        }
        pos = 4;
        while (!stock.isEmpty() && pos >= 0) {
            maxPos[pos--] = stock.pollLast();
        }
        if (pos > -1) maxPos[pos + 1]--;
        stock.clear();
        for (int i = 0; i < 5; i++) {
            max += intValues[maxPos[i]];
        }
    }

    private static void find5bit(int to, int pos, int sum, int lpos) {
        if (to == 5) {
            if (!all.contains(sum)) {
                total += sum;
                all.add(sum);
            }

        } else {
            for (int i = minPos[pos]; i <= maxPos[pos]; i++) {
                if (i < lpos) {
                    sum += intValues[i];
                    find5bit(to + 1, pos - 1, sum, i);
                    sum -= intValues[i];
                } else {
                    sum += intValues[i - 1];
                    find5bit(to + 1, pos - 1, sum, i);
                    sum -= intValues[i - 1];
                }
            }
        }
    }
}
