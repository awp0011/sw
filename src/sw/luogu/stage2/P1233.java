package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1233 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] S = new int[n][2];
        int[] bin = new int[n + 5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            S[i][0] = Integer.parseInt(st.nextToken());
            S[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(S, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] == o1[0]?o2[1] - o1[1]:o2[0] - o1[0];
            }
        });
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (S[i][1] > bin[ans]) {
                bin[++ans] = S[i][1];
            } else {
                int l = 0, r = ans;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (bin[mid] >= S[i][1]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                bin[l] = S[i][1];
            }
        }
        System.out.println(ans);
    }

}
