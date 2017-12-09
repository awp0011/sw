package sw.pro.SDS_PRO_9_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

public class source {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pointNum = Integer.parseInt(br.readLine());
        point[] vertex = new point[pointNum];


        for (int i = 0; i < pointNum; i++) {
            vertex[i] = new point();
        }
        for (int i = 0; i < pointNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            vertex[i].x = Integer.parseInt(st.nextToken());
            vertex[i].y = Integer.parseInt(st.nextToken());
        }
        br.close();
        DecimalFormat formatter = new DecimalFormat();
        formatter.setMaximumFractionDigits(1);
        formatter.setRoundingMode(RoundingMode.UP);
        System.out.println(calculate(vertex, pointNum));


    }

    public static String calculate(point vertex[], int pointNum) {
        int i = 0;
        BigDecimal temp = BigDecimal.ZERO;
        for (; i < pointNum - 1; i++) {
            temp = temp.add(BigDecimal.valueOf((vertex[i].x - vertex[i + 1].x)).multiply(BigDecimal.valueOf((vertex[i].y + vertex[i + 1].y))));
        }
        temp =temp.add(BigDecimal.valueOf((vertex[i].x - vertex[0].x)).multiply(BigDecimal.valueOf((vertex[i].y + vertex[0].y))));
        //temp += (vertex[i].x - vertex[0].x) * (vertex[i].y + vertex[0].y);
        temp = temp.divide(BigDecimal.valueOf(2)).abs().setScale(1, BigDecimal.ROUND_HALF_UP);
        return temp.toString();

    }

    static class point {
        public int x;
        public int y;

        point() {
            this.x = 0;
            this.y = 0;
        }
    }
}