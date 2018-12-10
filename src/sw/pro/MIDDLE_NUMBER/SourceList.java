package sw.pro.MIDDLE_NUMBER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

class SourceList {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = parseInt(br.readLine());
        List<Integer> d = new ArrayList<>(100_000);
        int t, index;
        for (int i = 1; i <= N; i++) {
            t = parseInt(br.readLine());
            index = Collections.binarySearch(d, t);
            if (index < 0) index = Math.abs(index + 1);
            d.add(index, t);
            System.out.println(index+" "+ Arrays.toString(d.toArray()));
            if (i % 2 == 1) {
                //sb.append()).append('\n');
                //bw.write(d.get(d.size() >> 1) + "");
                //bw.newLine();
                System.out.println(d.get(d.size() >> 1));
            }
            //if (i % 1000 == 0) bw.flush();
        }
        //System.out.print(sb.toString());
        //bw.flush();
        //bw.close();
        br.close();
    }
}
