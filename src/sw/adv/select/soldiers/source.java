package sw.adv.select.soldiers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class source {
    private static int[][] soldiers = new int[10_0001][3];
    private static int max_offensive_index;
    private static int max_defense_index;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 1; i <= T; i++) {
            int answer = 0;
            int size = Integer.parseInt(br.readLine());
            max_offensive_index = -1;
            max_defense_index = -1;
            for (int j = 0; j < size; j++) {
                st = new StringTokenizer(br.readLine());
                soldiers[j][0] = Integer.parseInt(st.nextToken());
                soldiers[j][1] = Integer.parseInt(st.nextToken());
                soldiers[j][2] = j;


                if (1 == soldiers[j][1]) {
                    max_defense_index = j;
                }

            }
            if (max_offensive_index == max_defense_index) {
                answer = 1;
            } else {
                Arrays.sort(soldiers, 0, size, Comparator.comparingInt(s -> s[0]));
                int index = 1;
                int current_max_offensive = soldiers[0][1];
                while (soldiers[index][2] != max_defense_index) {
                    if (soldiers[index][1] < current_max_offensive) {
                        answer++;
                        current_max_offensive = soldiers[index][1];
                    }
                    index++;
                }
            }
            System.out.println("#" + i + " " + answer);
        }
    }
}
