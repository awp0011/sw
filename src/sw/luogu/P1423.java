package sw.luogu;

import java.util.Scanner;

public class P1423 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double t = sc.nextDouble();
        double first = 2.0;
        int i = 1;
        double len=0;
        for (;  ; i++) {
            len += first;
            if(len>=t) break;
            first *= 0.98;
        }
        System.out.println(i);
    }

}
