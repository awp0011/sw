package sw.pro;

import java.util.HashSet;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(2_000_000_000);

        System.out.println(Integer.bitCount(2_000_000_000));
        System.out.println(Integer.toBinaryString(2_000_000_000));
        System.out.println(Integer.toBinaryString(2_000_000_000).length());
    }
}

