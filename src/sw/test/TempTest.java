package sw.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        long pre = 0;
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            int k = (int) in.nval;
            pre = Math.max(pre + k, k);
            max = Math.max(max, pre);
        }
        System.out.println(max);

    }
}