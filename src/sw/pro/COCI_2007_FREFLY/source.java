package sw.pro.COCI_2007_FREFLY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//可以尝试使用线段树

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] height = new int[H + 1];
        height[0] = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int c = Integer.parseInt(br.readLine());
            if ((i & 1) == 0) {
                for (int j = 1; j <= c; j++) {
                    height[j]++;
                }
            } else {
                for (int j = height.length - 1; j >= height.length - c; j--) {
                    height[j]++;
                }
            }
        }
        br.close();
        Arrays.sort(height);
        int min = height[0];
        int counter=0;
        for (int i = 0; i <= H; i++) {
            if(height[i]==min) counter++;
            else break;
        }
        System.out.println(min+" "+counter);


    }
}