package sw.pro.SDS_PRO_4_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
class source {
    static int[]                glass   = new int[1001];
    static Field[]              fields  = new Field[1001];
    static LinkedList<Field>  queue   = new LinkedList<>();
     
    public static void main(String[] args) throws Exception {
         
        int[] cow = new int[101];
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
         
        for (int i = 1; i <= K; i++) {
            cow[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 1; i <= N; i++) {
            fields[i] = new Field(0);
        }
        int p;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            Field f = new Field(Integer.parseInt(st.nextToken()));
            f.next = fields[p].next;
            fields[p].next = f;
        }
        for (int i = 1; i <= K; i++) {
            if (glass[cow[i]] == i - 1) {
                glass[cow[i]] = i;
            }
            queue.add(fields[cow[i]].next);
            bfs(i);
            // System.out.println(Arrays.toString(Arrays.copyOf(glass, N + 1)));
        }
        System.out.println(Arrays.stream(glass).filter(i -> i >= K).count());
    }
     
    static void bfs(final int visitor) {
        while (!queue.isEmpty()) {
            Field nextFild = queue.poll();
            while (nextFild != null) {
                nextFild.visited = visitor;
                if (glass[nextFild.index] == visitor - 1) {
                    glass[nextFild.index] = visitor;
                }
                if (fields[nextFild.index].next != null
                        && fields[nextFild.index].next.visited != visitor) {
                    queue.add(fields[nextFild.index].next);
                }
                 
                nextFild = nextFild.next;
            }
        }
    }
     
    static class Field {
        int     index;
        Field   next;
        int     visited;
         
        Field(int i) {
            index = i;
            visited = 0;
        }
    }
}