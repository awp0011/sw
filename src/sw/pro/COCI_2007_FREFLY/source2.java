package sw.pro.COCI_2007_FREFLY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class source2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] b1 = new int[(N >> 1) + 1];
        int[] b2 = new int[(N >> 1) + 1];
        int[] height = new int[H + 1];
        height[0] = Integer.MAX_VALUE;
        int i;
        for (i = 0; i < N >> 1; i++) {
            b1[i] = Integer.parseInt(br.readLine());
            b2[i] = Integer.parseInt(br.readLine());
        }
        b1[i] = Integer.MAX_VALUE;
        b2[i] = Integer.MAX_VALUE;
        br.close();
        Arrays.sort(b1);
        int counter = 1;
        for (i = 0; i < b1.length - 1; i++) {
            if (b1[i] == b1[i + 1]) counter++;
            else {
                for (int j = 1; j <= b1[i]; j++) {
                    height[j] += counter;
                }
                counter = 1;
            }
        }

        counter = 1;
        Arrays.sort(b2);
        for (i = 0; i < b2.length - 1; i++) {
            if (b2[i] == b2[i + 1]) counter++;
            else {
                for (int j = height.length - 1; j >= height.length - b2[i]; j--) {
                    height[j] += counter;
                }
                counter = 1;
            }
        }


        Arrays.sort(height);
        final int min = height[0];
        counter = 0;
        for (i = 0; i <= H; i++) {
            if (height[i] == min) counter++;
            else break;
        }
        System.out.println(min + " " + counter);


    }


}


