package sw.pro.SDS_PRO_2_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {

    private static int[] start = new int[]{0,1,1,5,5,21,21,85,85,341,341};
    private static int N, N_END, M, M_END, answer;
    private static int[] board = new int[11];

    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        int x, y;
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            N_END = 1 << N;
            M_END = 1 << M;
            for (x = 0; x < N; x++) {
                char[] flags = br.readLine().toCharArray();
                for (y = 0; y < M; y++) {
                    flags[y] = flags[y] == 'x' ? '0' : '1';
                }
                board[x] = Integer.valueOf(new String(flags), 2);
                //System.out.print(board[x] + "--");
                //System.out.println(new String(flags));
            }
            answer = 0;
            putKnight(0, 0, 0);
            System.out.println(answer);

        }
        br.close();
    }

    private static void putKnight(final int prevRow, final int row, final int sum) {
        if (row == N) {
            //System.out.println("LastRow:" + Integer.toBinaryString(prevRow));
            if (sum > answer) {
                answer = sum;
                //System.out.println("sum:" + sum);
            }
        } else {

            int index_m = start[M];
            while (index_m < M_END) {
                int current = index_m & board[row];
                //if (row == 0) System.out.println("FirstRow:" + Integer.toBinaryString(current));
                if ((prevRow & current >> 1) == 0 && (prevRow & current << 1) == 0) {
                    putKnight(current, row + 1, sum + Integer.bitCount(current));
                }
                index_m <<= 1;
            }
        }
    }

}
