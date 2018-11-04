package sw.pro.armyline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class source {

    private static int[] firstLine = new int[10005];
    private static int[] secondLine = new int[10005];
    private static int length = 0;
    private static int MOD = 100000007;
    //VM option:  -Xmx256m
    public static void main(String[] args) throws Exception {
        //简单测试法:
        long startTime = System.currentTimeMillis();   //获取开始时间

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(br.readLine());
        for (int i = 1; i <= T; i++) {
            length = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= length; j++) {
                firstLine[j] = Integer.valueOf(st.nextToken());
            }
            System.out.println("#" + i + " " + solve(length));
        }
        br.close();
        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private static int solve(final int armyLength) {
        Arrays.fill(secondLine, 1, firstLine[armyLength] + 1, 1);
        secondLine[firstLine[armyLength] + 1] = 0;//
        for (int i = armyLength - 1; i > 0; i--) {
            for (int j = firstLine[i + 1]; j > 0; j--) {
                if (j > firstLine[i]) {
                    secondLine[j - 1] = (secondLine[j - 1] + secondLine[j]) % MOD;
                    secondLine[j] = 0;
                } else {
                    secondLine[j] = (secondLine[j] + secondLine[j + 1]) % MOD;
                }
            }
        }
        return secondLine[1];
    }
}
