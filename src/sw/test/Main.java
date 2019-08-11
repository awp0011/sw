package sw.test;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int a = cin.nextInt(), b = cin.nextInt();
        int c = cin.nextInt(), d = cin.nextInt();
        if (d < b) {
            d = d + 60 - b;
            c--;
        }else{
            d = d  - b;
        }
        c = c - a;
        System.out.println(c + " " + d);
    }
}

