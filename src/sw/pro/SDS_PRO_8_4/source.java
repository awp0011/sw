package sw.pro.SDS_PRO_8_4;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char[] source = bufferedReader.readLine().toCharArray();
        bufferedReader.close();

        int left_row = source.length % 5;
        int wholeRow_cnt = (source.length - left_row) / 5;

        char[] target = new char[source.length];
        int src_index = 0;
        int[] column_cnt = new int[5];
        for (int i = 0; i < 5; i++) {
            column_cnt[i] = wholeRow_cnt + ((left_row > i) ? 1 : 0);
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < column_cnt[i]; j++) {
                target[ j * 5 + i] = source[src_index];
                //System.out.print(base_index + j * 5 + i+" ");
                src_index++;
            }
            //System.out.println();
        }
        //System.out.println(new String(target));

        for (int i = 0; i < target.length; i++) {
            int temp = (int)target[i] - 3;
            if (temp < 97) {
                target[i] = (char) ((int)target[i]+23);
            } else {
                target[i] = (char) (temp);
            }

        }

        System.out.println(new String(target));
    }
}