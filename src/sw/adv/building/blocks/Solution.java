package sw.adv.building.blocks;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    //
    private static int[][] blocks = new int[102][102];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        long startTime = System.currentTimeMillis();
        StringTokenizer st1, st2;
        int N, K, maxV;
        for (int t = 1; t <= T; t++) {
            st1 = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st1.nextToken());
            K = Integer.parseInt(st1.nextToken());
            maxV = Integer.MIN_VALUE;
            st1 = new StringTokenizer(br.readLine());
            st2 = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int index = Integer.parseInt(st2.nextToken());
                int value = Integer.parseInt(st1.nextToken());
                blocks[index][0] += 1;
                blocks[index][blocks[index][0]] = value;
            }
            for (int j = 1; j <= K; j++) {
                Arrays.sort(blocks[j], 1, blocks[j][0]);
            }

            for (int i = K; i > 0; i--) {
                int sum = 0, cnt = 0;
                for (int j = i; j > 0; j--) {
                    for (int k = blocks[j][0]; k >= 1; k--) {
                        sum += blocks[j][k];
                        cnt++;
                        if (cnt == K) break;
                    }
                    if (cnt == K) break;
                }
                maxV = Math.max(maxV, sum);
            }
            System.out.println("#" + t + " " + maxV);
            for (int[] b : blocks) {
                Arrays.fill(b, 0);
            }
        }
        //TO-Do
        // Solution
        long endTime = System.currentTimeMillis();
        //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }


}