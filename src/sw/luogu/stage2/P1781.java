package sw.luogu.stage2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1781 {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        int index = 0;
        String bigVote = "0";
        for (int i = 0; i < n; i++) {
            String next = sc.readLine();
            if (next.length() > bigVote.length()) {
                index = i + 1;
                bigVote = next;
            } else if (next.length() == bigVote.length()) {
                if (next.compareTo(bigVote) > 0){
                    index = i + 1;
                    bigVote = next;
                }
            }

        }

        System.out.println(index);
        System.out.println(bigVote);

    }

}
