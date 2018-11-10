package sw.pro.SDS_PRO_7_8;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    private static int latest = 1_000_000_001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] buildings = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildings[i][0] = Integer.parseInt(st.nextToken());
            buildings[i][1] = Integer.parseInt(st.nextToken());
            buildings[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(buildings, (a1, a2) -> {
            if (a1[0] == a2[0]) {
                return a2[1] - a1[0];
            } else {
                return a1[0] - a2[0];
            }
        });

        Building start = new Building(0);
        Building end = new Building(latest);
        start.right = end;
        end.left = start;

        join(start, new Building(buildings[0][0], buildings[0][2]));
        join(start.right, new Building(buildings[0][1], buildings[0][2]));

        Building current = start.right;
        for (int i = 1; i < N; i++) {
            Building si = new Building(buildings[i][0], buildings[i][2]);
            current = insert(current, si);
            Building ei = new Building(buildings[i][1], buildings[i][2]);
            insert(current, ei);
        }
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        current = start.right;
        while (current.right.axisX != latest) {
            if (current.height != current.left.height) {
                answer++;
                sb.append(current.axisX).append(" ").append(current.height).append('\n');
            }

            current = current.right;
        }
        System.out.println(answer);
        System.out.println(sb.toString());
    }


    private static Building insert(Building start, Building next) {
        Building current = start;
        do {
            if (current.right.axisX == latest && current.axisX != latest && current.height != 0) {
                Building aNew = new Building(current.axisX + 1);
                join(current, aNew);
            }
            if (current.right.axisX < next.axisX) {
                current = current.right;

            } else {
                if (current.axisX == next.axisX) {
                    current.height = current.height < next.height ? next.height : current.height;
                } else if (current.right.axisX == next.axisX) {
                    current = current.right;
                    current.height = current.height < next.height ? next.height : current.height;
                } else {
                    if (!(next.height < current.right.height && next.height < current.height)) {
                        join(current, next);
                    }
                }
                break;
            }

        } while (true);
        return current;
    }

    private static void join(Building first, Building second) {
        first.right.left = second;
        second.right = first.right;
        first.right = second;
        second.left = first;
    }

    private static class Building {
        int axisX;
        int height;
        Building left;
        Building right;

        Building(final int x, final int h) {
            axisX = x;
            height = h;
        }

        Building(final int x) {
            axisX = x;
            height = 0;
        }


    }
}
