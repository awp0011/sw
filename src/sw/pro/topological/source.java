package sw.pro.topological;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
 
class source {
    static int[]    Varray;
    static int[][]  Earray;
    static int      V, E, next;
 
    public static void main(String[] args) throws Exception {
 
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tcArr =  br.readLine().split(" ");
        V = Integer.parseInt(tcArr[0]);
        E = Integer.parseInt(tcArr[1]);
        Varray = new int[V + 1];
        Earray = new int[E + 1][2];
        for (int i = 1; i <= E; i++) {
            tcArr = br.readLine().split(" ");
            Earray[i][0] = Integer.parseInt(tcArr[0]);
            Earray[i][1] = Integer.parseInt(tcArr[1]);
            // 入度+1
            Varray[Earray[i][1]] += 1;
        }
        next = getNextV();
        while (next != -1) {
            System.out.print(next + " ");
            removeEdges(next);
            next = getNextV();
        }
 
        // 完成一个Testcase
        System.out.println("");
    }
 
    static int getNextV() {
        int result = -1;
        int i = 1;
        while (i <= V && result == -1) {
            if (Varray[i] == 0) {
                result = i;
                Varray[i] = -1;
            }
            i++;
        }
        return result;
    }
 
    static void removeEdges(final int v) {
        Arrays.stream(Earray).filter(arr -> arr[0] == v).forEach(arr -> Varray[arr[1]] -= 1);
    }
}
