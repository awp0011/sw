package sw.adv.hate.mosquito;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        //简单测试法:
        long startTime = System.currentTimeMillis();
        //获取开始时间

        List<Pray> queue = new LinkedList<>();
        StringTokenizer st;
        Pray key = new Pray(0);
        double x, y;
        int index;
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Double.parseDouble(st.nextToken());
                y = Double.parseDouble(st.nextToken()) - 50000d;
                if (y > 0) key.axisX = x - y / 2;
                else key.axisX = x + 2 * y;
                index = Collections.binarySearch(queue, key, Comparator.comparing(Pray::getIndex));
                if (index < 0) queue.add(0 - (index + 1), new Pray(key.axisX));
            }

            System.out.println("#" + t + " " + queue.size());
            queue.clear();
        }


        //TO-Do
        //Solution


        long endTime = System.currentTimeMillis();
        //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    static class Pray {
        double axisX;

        Pray(double x) {
            axisX = x;
        }

        double getIndex() {
            return axisX;
        }

    }
}
