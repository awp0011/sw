package hackerrank;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        double meal_cost = in.nextDouble();
        int tip_percent = in.nextInt();
        int tax_percent = in.nextInt();
        double tip = meal_cost *((double)tip_percent/100d);
        double tax =  meal_cost * ((double)tax_percent/100d);
        meal_cost += tip+tax;
        System.out.println("The total meal cost is "+Math.round(meal_cost)+" dollars.");
        in.close();
    }
}
