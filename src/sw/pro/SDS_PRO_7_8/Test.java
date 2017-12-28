package sw.pro.SDS_PRO_7_8;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 6, 7, 10};
        System.out.println(Arrays.binarySearch(a, 1));
        System.out.println(Arrays.binarySearch(a, 0));
        System.out.println(Arrays.binarySearch(a, 15));
        System.out.println(Arrays.binarySearch(a, 2));
        System.out.println(Arrays.binarySearch(a, 3));
        System.out.println(Arrays.binarySearch(a, 4));
        System.out.println(Arrays.binarySearch(a, 10));
        System.out.println();
        System.out.println(lowerBinarySearch(a, 1));
        System.out.println(lowerBinarySearch(a, 0));
        System.out.println(lowerBinarySearch(a, 15));
        System.out.println(lowerBinarySearch(a, 2));
        System.out.println(lowerBinarySearch(a, 3));
        System.out.println(lowerBinarySearch(a, 4));
        System.out.println(lowerBinarySearch(a, 10));


    }

    private static int lowerBinarySearch(int[] a, int key) {
        if (key <= a[0]) return 0;
        if (key > a[a.length - 1]) return a.length;
        int pos = Arrays.binarySearch(a, key);

        boolean isClose = false;
        while (!isClose) {
            if (pos == 0 || a[pos - 1] != key) isClose = true;
            else  pos--;
        }

        return pos;
    }

}
