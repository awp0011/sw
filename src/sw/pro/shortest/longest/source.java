package sw.pro.shortest.longest;

/*
1.求多点源的任意两点的最短路径,即所有点对间的最短路径 All Pairs Shortest Path(A.P.S.P.)
  算法 Floyed
  for(int k=1;<=N;k++){
   for(int i=1;i<=N;i++){
      for(int j=1;j<=N;j++){
         map[i][j]=min(map[i][j],map[i][k]+map[k][j]);//求出所有点对间最短路径
      }
   }
 }
2.每次减少一个点和点对应的线段，求最长的最短路径
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {
    private static int inf = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(1000);
        for (int tc = 1; tc <= T; tc++) {


            int N = Integer.parseInt(br.readLine());
            int[] delete_op = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] map = new int[N + 2][N + 2];
            int[][] tmp = new int[N + 2][N + 2];
            for (int i = 0; i < N; i++) {
                delete_op[i] = Integer.parseInt(st.nextToken());
                Arrays.fill(map[i + 1], inf);
            }

            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = i + 1; j <= N; j++) {
                    int t = Integer.parseInt(st.nextToken());
                    map[i][j] = t == 0 ? inf : t;
                    map[j][i] = map[i][j];
                }
            }
            //printArray(map);

            sb.append('#').append(tc);
            int n = 1;
            do {
                copy(map, tmp);
                sb.append(' ').append(floyed(tmp, N));
                //delete_op[n-1]
                Arrays.fill(map[delete_op[n - 1]], inf);
                for (int j = 1; j < map.length; j++) {
                    map[j][delete_op[n - 1]] = inf;
                }
                n++;
            } while (n < N);
            sb.append(' ').append(0);
            System.out.println(sb.toString());
            sb.delete(0,sb.length());
        }

        //printArray(map);
    }

    private static void copy(int[][] a1, int[][] a2) {
        for (int i = 1; i < a1.length; i++) {
            System.arraycopy(a1[i], 1, a2[i], 1, a1.length - 1);
        }
    }

    private static int floyed(int[][] data, int size) {
        int longest = 0;
        for (int k = 1; k <= size; k++) {
            for (int i = 1; i <= size; i++) {
                int t = data[i][k];
                if (t == inf) continue;//跳过不存在的路径
                for (int j = 1; j <= i; j++) {
                    if (i == j) continue;
                    data[i][j] = Math.min(data[i][j], t + data[k][j]);//求出所有点对间最短路径
                    //data[j][i] = data[i][j];
                    if(data[i][j]!=inf) longest = Math.max(longest, data[i][j]);
                }
            }
        }
        return longest;
    }

    private static void printArray(int[][] array) {
        System.out.println("---------start----------");
        Arrays.stream(array).forEach(s -> System.out.println(Arrays.toString(s)));
        System.out.println("---------end----------");
        System.out.println();
    }

}