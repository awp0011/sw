package sw.pro.SDS_PRO_1_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Online {
    private static Altitude[][] area;
    private static int N;
    private static int minAltitude = 200;
    private static int maxAltitude = 0;
    private static Map<Integer, ArrayList<Altitude>> all_altitudes = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        N = Integer.parseInt(br.readLine());
        area = new Altitude[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int height = Integer.parseInt(st.nextToken());
                minAltitude = Math.min(minAltitude, height);
                maxAltitude = Math.max(maxAltitude, height);
                final Altitude altitude = new Altitude(i, j, height);
                area[i][j] = altitude;
                all_altitudes.computeIfAbsent(height, v -> new ArrayList<>(20)).add(altitude);
            }
        }
        int low = 0, height = maxAltitude - minAltitude, middle;
        while (low < height) {
            middle = (low + height) >> 1;
            if (gotoNN(middle)) {
                height = middle;
            } else {
                low = middle + 1;
            }
        }
        System.out.println(low);

    }

    private static boolean gotoNN(int minHeight) {
        int current_start = minAltitude;
        Arrays.stream(area).forEach(row -> Arrays.stream(row).forEach(Altitude::init));
        while (!isArrivedNN() && current_start + minHeight <= maxAltitude) {
            Arrays.stream(area).forEach(row -> Arrays.stream(row).forEach(Altitude::init));
            int each = 0;
            while (each <= minHeight) {
                gotoNextContour(current_start + each);
                each++;
            }
            current_start++;
        }
        return isArrivedNN();

    }

    private static boolean isArrivedNN() {
        return find(area[0][0]).equals(find(area[N - 1][N - 1]));
    }

    private static void gotoNextContour(int height) {
        ArrayList<Altitude> contour = all_altitudes.get(height);
        if (contour != null) {
            for (Altitude altitude : contour) {
                altitude.isOnLine = true;
            }
            for (Altitude altitude : contour) {
                unionAround(altitude);
            }
        }

    }

    private static Altitude find(Altitude altitude) {
        if (altitude.parent.equals(altitude)) {
            return altitude;
        } else {
            return altitude.parent = find(altitude.parent);
        }
    }

    private static void unionAround(Altitude altitude) {
        int next = altitude.X + 1;
        if (next < N) {
            union(altitude, area[next][altitude.Y]);
        }
        next = altitude.Y + 1;
        if (next < N) {
            union(altitude, area[altitude.X][next]);
        }
        if (altitude.X > 0) {
            union(altitude, area[altitude.X - 1][altitude.Y]);
        }

        if (altitude.Y > 0) {
            union(altitude, area[altitude.X][altitude.Y - 1]);
        }
    }

    private static void union(Altitude a, Altitude b) {
        if (a.parent.equals(b.parent)) return;
        if (!b.isOnLine || !a.isOnLine) return;

        Altitude pa = find(a);
        Altitude pb = find(b);
        if (pa.child_cnt > pb.child_cnt) {
            b.parent.parent = a.parent;
            pa.child_cnt += pb.child_cnt;
        } else {
            a.parent.parent = b.parent;
            pb.child_cnt += pa.child_cnt;
        }

    }

    private static class Altitude {
        int X;
        int Y;
        int height;
        int child_cnt;
        boolean isOnLine;
        Altitude parent;

        boolean equals(Altitude other) {
            return other != null && other.X == X && other.Y == Y;
        }

        Altitude(final int x, final int y, final int h) {
            X = x;
            Y = y;
            height = h;
            child_cnt = 1;
            isOnLine = false;
            parent = this;
        }

        void init() {
            child_cnt = 1;
            isOnLine = false;
            parent = this;
        }
    }

}
