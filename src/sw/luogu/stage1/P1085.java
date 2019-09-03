package sw.luogu.stage1;

import java.util.Scanner;

public class P1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] week = new int[10];
        int day=0,fee=0;
        for (int i = 1; i < 8; i++) {
            week[i] = sc.nextInt() + sc.nextInt();
            if(week[i]>fee){
                fee = week[i];
                day = i;
            }
        }
        System.out.println(day);
    }
}
