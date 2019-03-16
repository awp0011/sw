package sw.pro.armyline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test {


    public static void main(String[] args)  {
        Integer a = Integer.valueOf("9999");
        HashSet<Integer> set = new HashSet<>();
        set.add(a);

        Integer b = Integer.valueOf("8888");
        Integer b1 = Integer.valueOf("8888");

        System.out.println(a.equals(b));
        System.out.println(b.equals(b1));
    }
}
