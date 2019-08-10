package sw.test;


import java.util.Scanner;

class Main {
    private static final double l1 = 0.4463;
    private static final double l2 = 0.4663;
    private static final double l3 = 0.5663;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        double fee = 0;
        if (t >= 401) {
            fee += l3 * (t - 400);
            t = 400;
        }
        if(t>=151){
            fee += l2 * (t - 150);
            t = 150;
        }
        fee += l1 * t ;
        System.out.printf("%.1f",fee);
    }
}