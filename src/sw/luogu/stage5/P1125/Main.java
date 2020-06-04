package sw.luogu.stage5.P1125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        String word = in.sval;
        int[] l = new int[30];
        for (int i = 0; i < word.length(); i++) l[word.charAt(i) - 'a']++;
        int min = 1000, max = -1;
        for (int i = 0; i < 26; i++) {
            if(l[i]==0)continue;
            min = Math.min(min, l[i]);
            max = Math.max(max, l[i]);
        }
        int p = max - min;
        boolean isPrime = true;
        if (p == 0) isPrime = false;
        else if (p == 1) isPrime = false;
        else {
            int end = (int)Math.sqrt(p);
            for (int i = 2; i <= end; i++) {
                if (p % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println(isPrime ? "Lucky Word" : "No Answer");
        System.out.println(isPrime ? p : 0);

    }
}
