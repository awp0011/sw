package sw.contest.second.B273048;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] padding = new String[]{"", "0", "00", "000", "0000", "00000"};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int[][] cities = new int[M][4];//[p,y,index,sort]

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cities[i][0] = parseInt(st.nextToken());
            cities[i][1] = parseInt(st.nextToken());
            cities[i][2] = i;
        }
        br.close();

        Arrays.sort(cities, (e1, e2) -> (e1[0] == e2[0]) ? (e1[1] - e2[1]) : (e1[0] - e2[0]));
        cities[0][3] = 1;
        for (int i = 1; i < M; i++) {
            cities[i][3] = (cities[i][0] == cities[i - 1][0]) ? cities[i - 1][3] + 1 : 1;
        }

        Arrays.sort(cities, Comparator.comparingInt(e -> e[2]));
        StringBuilder sb = new StringBuilder(100000 * 13);

        for (int[] city : cities) {
            sb.append(padding[getZeroCnt(city[0])]).append(city[0]);
            sb.append(padding[getZeroCnt(city[3])]).append(city[3]).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static int getZeroCnt(int n) {
        if (n < 10) return 5;
        else if (n < 100) return 4;
        else if (n < 1000) return 3;
        else if (n < 10000) return 2;
        else if (n < 100000) return 1;
        else return 0;
    }
}
