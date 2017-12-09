package sw.pro.SDS_PRO_2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class source {

    private static Map<Integer, List<Integer>> data = new HashMap<>();

    public static void main(String[] args) throws Exception {
        int M, N;
        int[] board = new int[11];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int x, y;
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            for (x = 0; x < M; x++) {
                int sum = 0;
                char[] flags = br.readLine().toCharArray();
                for (y = N - 1; y > 0; y--) {
                    sum += flags[y] == 'x' ? (1 << (N-y)) : 0;
                }
                board[x] = ~sum;
                //System.out.print(Integer.toBinaryString(sum) + "--");
                //System.out.println(Integer.toBinaryString(board[x]));
            }
            int answer = 0;


            Arrays.fill(board, 0);
            System.out.println("-----");
        }
        br.close();
    }

    private static void init() {
        int i, j;
        for (i = 0; i <= 341; i++) {
            //index = 0;
            for (j = 0; j <= 341; j++) {
                if (Integer.bitCount(i) > 5 || Integer.bitCount(j) > 5) continue;
                if (((i << 1) & j) == 0 && ((i >> 1) & j) == 0 && !check11(j)) {
                    data.computeIfAbsent(i, v -> new ArrayList<Integer>(11)).add(j);
                }
            }
        }
    }

    private static boolean check11(int n) {
        int i = n;
        while (i > 0) {
            if ((i & 1) == 1 && ((i >> 1) & 1) == 1) {
                return true;
            }
            i >>= 1;
        }
        return false;
    }

}
