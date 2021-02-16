package algorighms.fourth.edition.chapter1;

import java.awt.geom.Point2D;
import java.util.Random;
import java.util.Scanner;

public class Main_1_2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[][] d = new double[2][N];
        Random random = new Random();
        random.nextDouble();

        for (int i = 0; i < N; i++) {
            d[0][i] = random.nextDouble();
            d[1][i] = random.nextDouble();
        }
        double min = Double.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                min = Math.min(min, Point2D.distance(d[0][i], d[1][i], d[0][j], d[1][j]));
            }
        }
        System.out.println("Mini dist:" + min);
    }
}
