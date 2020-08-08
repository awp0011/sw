package sw.luogu.stage5.P4136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        while (true) {
            in.nextToken();
            int n = (int) in.nval;
            if (n == 0) break;
            if (n % 2 == 0) System.out.println("Alice");
            else System.out.println("Bob");
        }
    }
}
