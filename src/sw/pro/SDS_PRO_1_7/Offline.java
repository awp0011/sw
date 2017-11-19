package sw.pro.SDS_PRO_1_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Offline {
    private static Altitude[][] area;
    private static int N;
    private static Map<Integer, ArrayList<Altitude>> all_altitudes = new HashMap<>();
    private static int[] diagonals, rows, cloumns;
    private static Integer[] altitudes;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());
        rows = new int[N];
        cloumns = new int[N];
        diagonals = new int[2 * N - 1];
        area = new Altitude[N][N];
        for (int x = 0; x < N; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                int height = Integer.parseInt(st.nextToken());
                final Altitude altitude = new Altitude(x, y, height);
                area[x][y] = altitude;
                all_altitudes.computeIfAbsent(height, v -> new ArrayList<>(20)).add(altitude);
            }
        }
        Arrays.fill(rows, N);
        //System.out.println("rows = " + Arrays.toString(rows));
        Arrays.fill(cloumns, N);
        //System.out.println("cloumns = " + Arrays.toString(cloumns));
        int index = 1;
        while (index <= N) {
            diagonals[index - 1] = index;
            diagonals[diagonals.length - index] = index;
            index++;
        }

        //System.out.println("diagonals = " + Arrays.toString(diagonals));
        altitudes = all_altitudes.keySet().toArray(new Integer[0]);
        //System.out.println("altitudes = " + Arrays.toString(altitudes));

        System.out.println(findMax() - findMin());

    }

    private static boolean isNecessary(int height) {
        if (height == area[0][0].height || height == area[N - 1][N - 1].height) {
            return true;
        }
        ArrayList<Altitude> contour = all_altitudes.get(height);
        int[] d = diagonals.clone();
        int[] r = rows.clone();
        int[] c = cloumns.clone();
        for (Altitude altitude : contour) {
            if (d[altitude.X + altitude.Y] == 1) {
                return true;
            } else {
                d[altitude.X + altitude.Y]--;
            }
            if (r[altitude.X] == 1) {
                return true;
            } else {
                r[altitude.X]--;
            }
            if (c[altitude.Y] == 1) {
                return true;
            } else {
                r[altitude.Y]--;
            }
        }
        diagonals = d;
        rows = r;
        cloumns = c;
        return false;
    }

    private static int findMin() {
        if (altitudes[0] == area[0][0].height) {
            return altitudes[0];
        }
        int height = 0;
        for (int altitude : altitudes) {
            height = altitude;
            if (isNecessary(height)) {
                break;
            }
        }
        return height;
    }

    private static int findMax() {
        if (altitudes[altitudes.length - 1] == area[N - 1][N - 1].height) {
            return altitudes[altitudes.length - 1];
        }
        int height = 0;
        for (int i = altitudes.length - 1; i > 0; i--) {
            height = altitudes[i];
            if (isNecessary(height)) {
                break;
            }
        }
        return height;
    }

    private static class Altitude {
        int X;
        int Y;
        int height;

        Altitude(final int x, final int y, final int h) {
            X = x;
            Y = y;
            height = h;
        }
    }

}
