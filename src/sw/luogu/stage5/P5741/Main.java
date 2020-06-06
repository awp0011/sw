package sw.luogu.stage5.P5741;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n][4];
        String[] names = new String[n];
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            for (int j = 0; j < 3; j++) {
                d[i][j] = Integer.parseInt(st.nextToken());
                d[i][3] += d[i][j];
            }
            if (i > 0) {
                for (int j = i - 1; j >= 0; j--) {
                    int sum = 0;
                    for (int k = 0; k < 3; k++) {
                        int t = Math.abs(d[i][k] - d[j][k]);
                        if (t <= 5) sum += 1;
                    }
                    if (sum == 3 && Math.abs(d[i][3] - d[j][3]) <= 10) {
                        ans.add(names[i].compareTo(names[j]) > 0 ? names[j] + " " + names[i] : names[i] + " " + names[j]);
                    }
                }

            }
        }
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}

