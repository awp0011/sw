package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P5733 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] src = br.readLine().toCharArray();
        for (int i = 0; i <src.length ; i++) {
            int n = src[i];
            if(n>=97 && n<=122){
                src[i] = (char)(n-32);
            }
        }
        System.out.println(new String(src));
    }
}
