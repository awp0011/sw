package sw.adv.sugguer.fish;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        //获取开始时间
        long startTime = System.currentTimeMillis();

        int ans;
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());

            if (D == 1) {
                int temp = X;
                X = Y;
                Y = temp;
            }
            if (N > (X >> 1)) {
                ans = Y + (X % N == 0 ? N - 1 : N);
            } else {
                ans = (X / N) * Y + (X % N == 0 ? N - 1 : N);
            }

            System.out.println("#" + t + " " + ans * 100);
        }


        long endTime = System.currentTimeMillis();
        //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }
}