package sw.pro.armyline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    private static List<Integer> numbers = new ArrayList<>(5000000);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            numbers.add(Integer.valueOf(br.readLine()));
        }

        Collections.sort(numbers);

        System.out.println(numbers.get(K - 1));
    }
}
