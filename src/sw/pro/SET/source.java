package sw.pro.SET;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        MyInt[] array = new MyInt[N + M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = new MyInt(Integer.parseInt(st.nextToken()), 0);
        }
        st = new StringTokenizer(br.readLine());
        int[] s = new int[M];
        for (int i = N; i < N + M; i++) {
            array[i] = new MyInt(Integer.parseInt(st.nextToken()), 1);
        }
//        Arrays.sort(array, Comparator.comparing(MyInt::getValue));

//        Arrays.stream(array).forEach(a-> System.out.print(a.value+" "));
//        System.out.println();

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i].flag != array[i + 1].flag) {
                int cur = Math.abs(array[i].value - array[i + 1].value);
                if (minDiff > cur) minDiff = cur;
            }
        }


        System.out.println(minDiff);
    }

    private static class MyInt {
        int value;
        int flag;

        MyInt(final int v, final int f) {
            value = v;
            flag = f;
        }

        int getValue() {
            return value;
        }
    }
}
