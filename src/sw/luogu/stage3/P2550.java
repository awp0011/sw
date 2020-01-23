package sw.luogu.stage3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P2550 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> nums = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            nums.add(Integer.parseInt(st.nextToken()));
        }
        int[] k = new int[8];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < 7; j++) {
                if (nums.contains(Integer.parseInt(st.nextToken()))) cnt++;
            }
            k[cnt]++;
        }
        for (int i = 7; i >0 ; i--) {
            System.out.print(k[i]+" ");
        }

    }

}
