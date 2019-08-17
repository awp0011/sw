package sw.adv.five.bit;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution2 {
    private static final int[] intValues = new int[31];
    private static final int[] maxPos = new int[]{25, 26, 27, 28, 29};
    private static final int[] all = new int[150001];
    private static long total;
    private static int index = 150000;

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 31; i++) {
            intValues[i] = 1 << i;
        }
        while (maxPos[4] != 4) {
            for (int i = 0; i <= 4; i++) {
                if (i == 4) {
                    maxPos[4]--;
                    for (int j = 3; j >= 0; j--) {
                        maxPos[j] = maxPos[j + 1] - 1;
                    }
                    all[index--] = toInt();
                } else {
                    while (maxPos[i] > i) {
                        maxPos[i]--;
                        all[index--] = toInt();
                    }
                }
            }
        }
        System.setIn(new FileInputStream("C:\\workspace\\idea\\sw\\src\\sw\\pro\\fiveone\\input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            int start = findFirst5Bit(sc.nextInt());
            int end = findLast5Bit(sc.nextInt());
            for (int i = start; i <= end; i++) {
                total += all[i];
            }
            System.out.println("#" + t + " " + total + " " + (total==0?0:all[start]));
            total = 0;
        }
    }

    private static int findFirst5Bit(int n) {
        int pos = Arrays.binarySearch(all, index, 150000, n);
        return pos < 0 ? (0 - (pos + 1)) : pos;
    }

    private static int findLast5Bit(int n) {
        int pos = Arrays.binarySearch(all, index, 150000, n);
        return pos < 0 ? (0 - (pos + 2)) : pos;
    }

    private static int toInt() {
        int intValue = 0;
        for (int i = 0; i < 5; i++) {
            intValue += intValues[maxPos[i]];
        }
        return intValue;
    }
}
