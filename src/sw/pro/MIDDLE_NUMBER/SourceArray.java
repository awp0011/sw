package sw.pro.MIDDLE_NUMBER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class SourceArray {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] d = new long[N + 1];
        long t;
        int index;
        for (int i = 1; i <= N; i++) {
            t = Long.parseLong(br.readLine());
            if (t <= d[1]) index = 1;
            else if (t >= d[i - 1]) index = i;
            else index = Arrays.binarySearch(d, 0, i, t);
            if (index < 0) index = Math.abs(index + 1);
            for (int j = i; j > index; j--) {
                d[j] = d[j - 1];
            }
            d[index] = t;
            if (i % 2 == 1) {
                bw.write(d[(i + 1) >> 1] + "");
                bw.newLine();
            }
            if (i % 1000 == 0) bw.flush();
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
