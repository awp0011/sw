package sw.luogu.stage4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] edges = new int[6];
        edges[0] = Integer.parseInt(st.nextToken());
        edges[1] = Integer.parseInt(st.nextToken());
        edges[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(edges, 0, 3);
        edges[3] = edges[0] * edges[0];
        edges[4] = edges[1] * edges[1];
        edges[5] = edges[2] * edges[2];


        if (edges[0] + edges[1] < edges[2]) {
            System.out.println("Not triangle");
        } else {
            if (edges[3] + edges[4] == edges[5]) {
                System.out.println("Right triangle");
            }
            if (edges[3] + edges[4] > edges[5]) {
                System.out.println("Acute triangle");
            }
            if (edges[3] + edges[4] < edges[5]) {
                System.out.println("Obtuse triangle");
            }
            if (edges[0] == edges[1]) {
                System.out.println("Isosceles triangle");
            }
            if (edges[0] == edges[1] && edges[0] == edges[2]) {
                System.out.println("Equilateral triangle");
            }
        }
    }
}
