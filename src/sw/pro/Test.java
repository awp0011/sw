package sw.pro;


import java.util.Arrays;

public class Test {

    private static final int[] maxPos = new int[]{1,3,6,8,9,11,15,24,25,27,28,29};

    public static void main(String[] args) {
        int t = Arrays.binarySearch(maxPos,10);
        int u = Arrays.binarySearch(maxPos,24);
        int v = Arrays.binarySearch(maxPos,26);
        System.out.println(0 - (t + 1));
        System.out.println(u);
        System.out.println(0 - (v + 2));
    }

}