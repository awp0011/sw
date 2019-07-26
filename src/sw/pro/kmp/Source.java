package sw.pro.kmp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


class source {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String context = br.readLine();
        String pattern = br.readLine();

        int[] P = new int[pattern.length()];
        P[0] = -1;
        int now = -1;

        for (int i = 1; i < pattern.length(); i++) {
            if (pattern.charAt(1 + now) == pattern.charAt(i)) {
                P[i] = ++now;
            } else if (now == -1) {
                P[i] = -1;
            } else {
                now = i - 1;
                while (now != -1) {
                    now = P[now];
                    if (pattern.charAt(now + 1) == pattern.charAt(i)) {
                        P[i] = now + 1;
                        break;
                    }
                }
                if (now == -1) P[i] = now;
            }
        }

        int p = 0;
        int i = 0;

        while (i < context.length()) {

            if (pattern.charAt(p) == context.charAt(i)) {
                if (p == pattern.length() - 1) {
                    int start = i + 1 - pattern.length();
                    if (start >= 0) {
                        context = context.substring(0, start) + context.substring(start + pattern.length());
                    }
                    i -= (pattern.length() - 1) + 1 + pattern.length();
                    p = -1;
                    i--;
                }
                p++;
                i++;

                if (p < 0) p = 0;
                if (i < 0) i = 0;
            } else {
                if (p == 0) i++;
                else {
                    while (p != 0) {
                        p = P[p - 1];
                        if (p == -1) {
                            p = 0;
                            break;
                        } else if (context.charAt(i) == pattern.charAt(p + 1)) {
                            p++;
                            break;
                        }
                    }
                }
            }
        }

        bw.write(context);

        bw.flush();
        bw.close();
    }
}