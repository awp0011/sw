package sw.pro.SDS_PRO_7_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Map<Integer, Axis> map = new HashMap<>(2 * N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int si = Integer.parseInt(st.nextToken());
            int ei = Integer.parseInt(st.nextToken());
            int hi = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(si - 1, v -> new Axis(v, 0)).addY(0);
            map.computeIfAbsent(si, v -> new Axis(v, hi)).addY(hi);
            map.computeIfAbsent(si + 1, v -> new Axis(v, hi)).addY(hi);
            map.computeIfAbsent(ei - 1, v -> new Axis(v, hi)).addY(hi);
            map.computeIfAbsent(ei, v -> new Axis(v, hi)).addY(hi);
            map.computeIfAbsent(ei + 1, v -> new Axis(v, 0)).addY(0);
        }
        br.close();
        Axis[] every = map.values().toArray(new Axis[0]);
        Arrays.sort(every, Comparator.comparingInt(Axis::getX));

        int counter=0;
        for (int i = 1; i < every.length; i++) {

            if (map.containsKey(every[i].X - 1) && every[i].Y != every[i - 1].Y) {
                counter++;
                bw.append(every[i].X + " " + every[i].Y);
                bw.newLine();
            }
        }
        System.out.println(counter);
        bw.flush();
        bw.close();

    }

    private static class Axis {
        int X;
        int Y;

        Axis(final int x, final int y) {
            X = x;
            Y = y;
        }

        void addY(final int y) {
            if (y > Y) {
                Y = y;
            }
        }

        int getX() {
            return X;
        }
    }
}
