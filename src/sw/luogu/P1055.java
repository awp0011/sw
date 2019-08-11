package sw.luogu;

import java.util.Scanner;

public class P1055 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char Zero = '0';
        char emp = '-';
        char[] str = sc.next().toCharArray();
        int offset = 1, check = 0;
        for (int i = 0; i < str.length - 1; i++) {
            if (str[i] == emp) continue;
            int n = str[i] - Zero;
            check += n * offset++;
        }
        check %= 11;
        if (check == 10) check = 'X' - Zero;
        if (check == str[str.length - 1] - Zero) {
            System.out.println("Right");
        } else {
            str[str.length - 1] = (char) ((int) Zero + check);
            System.out.println(new String(str));
        }
    }
}
