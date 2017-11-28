package sw.pro.NQUEEN;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {

    static int sum = 0, upperlim = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        upperlim = (upperlim << N) - 1; // 初始化 转成二进制后为 全是11111111111111111
        test(0, 0, 0);
        System.out.println(sum);

    }

    static void test(int row, int ld, int rd) {
        //row 已经放置了Queen的情况
        //ld 斜向中不能放置Queen位置（右上到左下）
        //rd 斜向中不能放置Queen位置（左上到右下）
        if (row != upperlim) {//
            int pos = upperlim & ~(row | ld | rd);//计算可以放置Queen的位置
            while (pos != 0) {//循环前行中所有可能放置Queen位置
                int p = pos & -pos;
                pos -= p;
                //递归，计算下一行中可以放置Queen的位置
                test(row + p, (ld + p) << 1, (rd + p) >> 1);
            }
        } else {
            sum++;
        }
    }

}
