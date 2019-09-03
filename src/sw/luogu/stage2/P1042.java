package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1042 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        boolean isGameOver = false;
        int w11 = 0, l11 = 0;
        int w21 = 0, l21 = 0;
        StringBuilder sb11 = new StringBuilder();
        StringBuilder sb21 = new StringBuilder();
        while (!isGameOver) {
            String score = in.readLine();
            for (int i = 0; i < score.length(); i++) {
                if (score.charAt(i) == 'E') {
                    isGameOver = true;
                    sb11.append(w11).append(':').append(l11).append('\n');
                    sb21.append(w21).append(':').append(l21).append('\n');
                    break;
                } else {
                    if (score.charAt(i) == 'W') {
                        w11++;
                        w21++;
                    } else {
                        l11++;
                        l21++;
                    }
                    if (w11 >= 11 && w11 - l11 >= 2) {
                        sb11.append(w11).append(':').append(l11).append('\n');
                        w11 = 0;
                        l11 = 0;
                    }
                    if (l11 >= 11 && l11 - w11 >= 2) {
                        sb11.append(w11).append(':').append(l11).append('\n');
                        w11 = 0;
                        l11 = 0;
                    }
                    if (w21 >= 21 && w21 - l21 >= 2) {
                        sb21.append(w21).append(':').append(l21).append('\n');
                        w21 = 0;
                        l21 = 0;
                    }
                    if (l21 >= 21 && l21 - w21 >= 2) {
                        sb21.append(w21).append(':').append(l21).append('\n');
                        w21 = 0;
                        l21 = 0;
                    }
                }

            }
        }
        System.out.println(sb11.toString());
        System.out.print(sb21.toString());
    }
}
