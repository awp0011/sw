package sw.test;


import java.util.Arrays;

class TempTest {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 5, 5, 5, 6, 6, 6, 8, 9, 10};
        System.out.println(Arrays.binarySearch(test, 5));
        System.out.println(Arrays.binarySearch(test, 6));

        test = new int[]{1, 2, 3, 4, 5, 5, 5, 6, 6, 6, 8, 9, 10, 11, 12, 13};
        System.out.println(Arrays.binarySearch(test, 5));
        System.out.println(Arrays.binarySearch(test, 6));


        System.out.println(Integer.MAX_VALUE);
        System.out.println(1_000_000_000L);

    }
}