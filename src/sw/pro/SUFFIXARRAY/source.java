package sw.pro.SUFFIXARRAY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class source {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        String[] array = new String[str.length()];
        for (int i =0;i<array.length;i++){
            array[i] = str.substring(i);
        }
        Arrays.sort(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
