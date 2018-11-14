package sw.test;

import java.util.Arrays;

class TempTest {
    public static void main(String[] args) {
        int[] temp = new int[]{0,10,30,50,70,90,20,40,60,80,100,0,0,0};
        Arrays.sort(temp,1,11);
        System.out.println(Arrays.binarySearch(temp,1,11,100));
        System.out.println(Arrays.binarySearch(temp,1,11,20));
        System.out.println(Arrays.binarySearch(temp,1,11,55));


    }
}