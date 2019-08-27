package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class P1177 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            d[i] = (int) in.nval;
        }
        quickSort(d,0,n-1);
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            ans.append(d[i]).append(' ');
        }
        System.out.print(ans.toString());

    }
    static void quickSort(int[] arr ,int s, int e) {
        int l = s;
        int r = e;
        int midnum = arr[(s + e) / 2];
        while (l < r) {
            while (arr[l] < midnum) {
                l++;
            }
            while (arr[r] > midnum) {
                r--;
            }
            if (l >= r) {
                break;
            }
            swap(arr,l, r);
            if (arr[l] == midnum) {
                r--;
            }
            if (arr[r] == midnum) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }
        if (s < r) {
            quickSort(arr,s, r);
        }
        if (e > l) {
            quickSort(arr,l, e);
        }
    }


    private static void swap(int[] d, int p1, int p2) {
        int temp = d[p1];
        d[p1] = d[p2];
        d[p2] = temp;
    }
}
