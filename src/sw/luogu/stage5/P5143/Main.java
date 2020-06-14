package sw.luogu.stage5.P5143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[][] d = new int[n][3];
        for (int i = 0; i <n ; i++) {
            in.nextToken();
            d[i][0] = (int) in.nval;
            in.nextToken();
            d[i][1] = (int) in.nval;
            in.nextToken();
            d[i][2] = (int) in.nval;
        }
        Arrays.sort(d, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        double ans = 0;
        for (int i = 1; i <n ; i++) {
            ans += cal(d[i],d[i-1]);
        }
        System.out.println(String.format("%.3f",ans));
    }

    private static double cal(int[] p,int[] q){
        return Math.sqrt(Math.pow(Math.abs(p[0]-q[0]),2)+
                Math.pow(Math.abs(p[1]-q[1]),2)+
                Math.pow(Math.abs(p[2]-q[2]),2));
    }
}
