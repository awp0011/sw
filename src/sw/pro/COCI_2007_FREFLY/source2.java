package sw.pro.COCI_2007_FREFLY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class source2 {
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
        Arrays.sort(b2);

        int min = Integer.MAX_VALUE, cnt = 0;
        for (int i = 0; i < H; ++i) {
            int temp = (N << 1) - lowerBinarySearch(b1, i + 1) - lowerBinarySearch(b2, H - i);
            //System.out.println(i+" "+ temp);
            if (temp < min) {
                min = temp;
                cnt = 1;
            } else if (temp == min) ++cnt;
        }
        System.out.println(min + " " + cnt);
    }

    private static int lowerBinarySearch(int[] a, int key) {
        if (key <= a[0]) return 0;
        if (key > a[a.length - 1]) return a.length;
        int pos = Arrays.binarySearch(a, key);

        boolean isClose = false;
        while (!isClose) {
            if (pos == 0 || a[pos - 1] != key) isClose = true;
            else  pos--;
        }

        return pos;
    }

}


