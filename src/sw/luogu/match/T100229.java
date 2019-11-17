package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class T100229 {
    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[][] tuple = new int[n][3];
        int x, y, z, size = 0;
        boolean flag;
        for (int i = 0; i < n; i++) {
            in.nextToken();
            x = (int) in.nval;
            in.nextToken();
            y = (int) in.nval;
            in.nextToken();
            z = (int) in.nval;
            flag = false;
            for (int j = 0; j < i && !flag; j++) {
                if (tuple[j][0] == x && tuple[j][1] == y && tuple[j][2] == z) flag = true;
            }
            if (!flag) {
                tuple[i][0] = x;
                tuple[i][1] = y;
                tuple[i][2] = z;
                size++;
            }
        }
        int cnt = 0,counter;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= m; k++) {
                    counter = 0;
                    for (int l = 0; l < size; l++) {
                        if(((Math.abs(tuple[l][0]-i))^(Math.abs(tuple[l][1]-j))^(Math.abs(tuple[l][2]-k)))==9)counter++;
                    }
                    if (counter==size) cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
