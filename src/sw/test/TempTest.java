package sw.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

class TempTest {
    public static void main(String[] args) {
        int[] temp = new int[]{10,30,50,70,90,20,40,60,80,100};
        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(10);
        ll.add(30);
        ll.add(70);
        ll.add(50);
        ll.add(20);
        ll.add(40);
        ll.add(60);
        ll.add(80);
        Collections.sort(ll);
        //System.out.println(Arrays.toString(temp));

        System.out.println(Collections.binarySearch(ll,100));
        System.out.println(Collections.binarySearch(ll,20));
        System.out.println(Collections.binarySearch(ll,550));
        System.out.println(Collections.binarySearch(ll,55));
        ll.add(5,55);

        System.out.println(Collections.binarySearch(ll,65));
        ll.add(7,65);
        System.out.println(Arrays.toString(ll.toArray()));
    }
}