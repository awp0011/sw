package sw.TP2019.M03.P04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.util.Arrays.binarySearch;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int[] aArray = new int[N+5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int lis = 0;
        for (int i = 0; i < N; i++) {
            int key = parseInt(st.nextToken());
            int index = binarySearch(aArray, 0, lis+1, key);
            if (index < 0) {
                index = abs(index+1);
                if (index > lis) lis = index;
            }
            aArray[index] = key;
        }
        System.out.println(lis);
    }
}
