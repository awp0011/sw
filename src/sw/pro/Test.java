package sw.pro;


import java.util.*;

public class Test {


    public static void main(String[] args) throws Exception {
        int l=0;
        for(;(1<<l)<=5;l++);//先计算上限
        l--;
        System.out.println(l);

    }


}

