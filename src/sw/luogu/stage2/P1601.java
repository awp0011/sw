package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1601 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String nums = br.readLine();
        int[] a = new int[nums.length() + 1];
        for (int i = 1; i < a.length; i++) {
            a[i] = nums.charAt(i - 1) - '0';
        }
        nums = br.readLine();
        int[] b = new int[nums.length() + 1];
        for (int i = 1; i < b.length; i++) {
            b[i] = nums.charAt(i - 1) - '0';
        }
        if (a.length > b.length) {
            a = add(a, b);
        } else {
            a = add(b, a);
        }
        StringBuilder ans = new StringBuilder();
        if (a[0] > 0) ans.append(a[0]);
        for (int i = 1; i < a.length; i++) {
            ans.append(a[i]);
        }
        System.out.println(ans.toString());
    }

    private static int[] add(int[] big, int[] small) {
        int btail = big.length - 1;
        int stail = small.length - 1;
        int carry = 0;
        while (stail > 0) {
            big[btail] += small[stail] + carry;
            if (big[btail] >= 10) {
                big[btail] %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            btail--;
            stail--;
        }
        while (carry==1){
            big[btail] +=  carry;
            if (big[btail] >= 10) {
                big[btail] %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            btail--;
        }
        return big;
    }
}
