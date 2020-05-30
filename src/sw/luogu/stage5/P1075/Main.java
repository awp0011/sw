package sw.luogu.stage5.P1075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        for (int i = 2; i < 10000000; i++) {
            if (isPrime(i)) {
                if (n % i == 0) {
/*                    int p = n / i;
                    if (isPrime(p)) {
                        System.out.println(p);
                        break;
                    }*/
                    System.out.println(n / i);
                    break;
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        int e = (int) Math.sqrt(n);
        boolean is = true;
        for (int i = 2; is && i <= e; i++) {
            if (n % i == 0) is = false;
        }
        return is;
    }
}
