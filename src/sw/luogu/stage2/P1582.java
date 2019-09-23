package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] nums = Integer.toBinaryString(N).toCharArray();
        int cnt1 = 0, head = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == '1') {
                cnt1++;
                if (cnt1 <= K) head = i;
            }
        }
        if (cnt1 <= K) System.out.println(0);
        else {
            int tail = nums.length - 1;
            int offset = 0;
            while (nums[tail] != '1') {
                tail--;
                offset++;
            }
            int ans = 1 << offset;
            while (tail > head) {
                if (nums[tail] == '0') ans += (1 << offset);
                offset++;
                tail--;
            }
            System.out.println(ans);
        }
    }
}
