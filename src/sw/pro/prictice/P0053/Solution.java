package sw.pro.prictice.P0053;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


/**
 * f[w][b]表示 w骑士结婚的概率，f[b][w]表示b骑士结婚的概率
 * 选2个w，留1个w--> 概率w2=选中2个W（组合数）* f[w-1][b]
 * 选2个b，留1个b--> 概率b2=选中2个b（组合数）* f[w][b-1]
 * 选1个w，1个b，都淘汰--> 概率w1b1=选中1个w，1个b（组合数）* f[w-1][b-1]
 **/
public class Solution {

    private static final double[][] f = new double[1003][1003];

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        for (int i = 1; i <= 1000; i++) {
            //f[0][j] = 0 表示仅有骑士j，骑士i结婚概率为0
            f[i][0] = 1;//表示仅有骑士i，骑士i结婚概率为1
            for (int j = 1; j <= 1000; j++) {
                double w2 = C(i) * f[i - 1][j];//抽到w2情况 * f[w-1][b]概率
                double b2 = C(j) * f[i][j - 1];//抽到b2情况 *  f[w][b-1]概率
                double w1b1 = (i * j) * f[i - 1][j - 1];//抽到w1b1情况 * f[w-1][b-1] 概率
                double all = C(i + j);//所有的情况
                f[i][j] = (w2 + b2 + w1b1) / all;
            }
        }


        in.nextToken();
        int T = (int) in.nval;
        for (int t = 1; t <= T; t++) {
            in.nextToken();
            int W = (int) in.nval;
            in.nextToken();
            int B = (int) in.nval;
            String ansW = String.format("%.7f", f[W][B]);
            String ansB = String.format("%.7f", f[B][W]);
            String oth = String.format("%.7f", (1d - f[W][B] - f[B][W]));
            System.out.println("#" + t + " " + ansW + " " + ansB + " " + oth);
        }
    }

    //n中选2的个数-->n*(n-1)/2
    private static int C(int n) {
        return (n * (n - 1)) >> 1;
    }
}
