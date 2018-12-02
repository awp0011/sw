package sw.contest.second.D273048;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            String line = br.readLine();
            while (line.charAt(0) != 'E') {
                System.out.println(line);
                line = br.readLine();
            }
        }
        while (br.ready());
        br.close();
    }

}
