package sw.test;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class CheckMemory {

    public static void main(String[] args) throws Exception {


        //简单测试法:
        long startTime = System.currentTimeMillis();   //获取开始时间


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());


        int[][] pool = new int[N][N];
        for (int i = 0; i < pool.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < pool.length; j++) {
                pool[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //TO-Do

        //source1


        long endTime = System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");


    }
}
