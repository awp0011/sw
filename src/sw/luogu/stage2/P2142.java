package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2142 {
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
        StringBuilder ans = new StringBuilder();
        if (a.length > b.length) {
            sub(a, b);
        } else if (a.length == b.length) {
            int index = 1;
            while (index < a.length && a[index] == b[index]) index++;
            if (index == a.length) {
                System.out.println(0);
                return;
            } else {
                if (a[index] > b[index]) {
                    a = sub(a, b);
                } else {
                    a = sub(b, a);
                    ans.append('-');
                }
            }
        } else {
            a = sub(b, a);
            ans.append('-');
        }
        int i = 0;
        while (a[i] == 0 && i < a.length) i++;
        for (; i < a.length; i++) {
            ans.append(a[i]);
        }
        System.out.println(ans.length() > 0 ? ans.toString() : "0");
    }

    private static int[] sub(int[] big, int[] small) {
        int btail = big.length - 1;
        int stail = small.length - 1;
        int carry = 0;
        while (stail > 0) {
            big[btail] -= carry;
            carry = 0;
            if (big[btail] < 0) {
                big[btail] += 10;
                carry = 1;
            }
            if (big[btail] >= small[stail]) {
                big[btail] -= small[stail];
            } else {
                big[btail] += 10 - small[stail];
                carry = 1;
            }
            btail--;
            stail--;
        }
        while (carry == 1) {
            big[btail] -= carry;
            if (big[btail] < 0) {
                big[btail] += 10;
                carry = 1;
            } else {
                carry = 0;
            }
            btail--;
        }
        return big;
    }
}
