package sw.pro.COCI_2007_FREFLY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()) >> 1;
        int H = Integer.parseInt(st.nextToken());
        int[] b1 = new int[N];
        int[] b2 = new int[N];
        for (int i = 0; i < N; i++) {
            b1[i] = Integer.parseInt(br.readLine());
            b2[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        Arrays.sort(b1);
        // System.out.println(Arrays.toString(b1));
        Arrays.sort(b2);
        // System.out.println(Arrays.toString(b2));

        int min = Integer.MAX_VALUE, cnt = 0;
        for (int i = 0; i < H; i++) {
            int temp = N - lowerBound(b1, i + 1) + N - lowerBound(b2, H - i);
            //System.out.println(i+" "+ temp);
            if (temp < min) {
                min = temp;
                cnt = 1;
            } else if (temp == min) cnt++;
        }
        System.out.println(min + " " + cnt);
    }

    private static int lowerBound(int[] numbs, int v) {
        int l = 0;
        int r = numbs.length;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (numbs[m] >= v) r = m;//因为是寻找下界，不考虑右边还有没有元素
            else if (numbs[m] < v) l = m + 1;
        }
        return l;
    }

}


