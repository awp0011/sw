package sw.pro.SD_PRO_4_2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
class source {
    static int[]            glass   = new int[1001];
    static Fild[]           parent  = new Fild[1001];
    static LinkedList<Fild>   queue   = new LinkedList<>();
 
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
            parent[i] = new Fild(0);
        }
        int p;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            Fild f = new Fild(Integer.parseInt(st.nextToken()));
            f.next = parent[p].next;
            parent[p].next = f;
        }
        for (int i = 1; i <= K; i++) {
            if (glass[cow[i]] == i - 1) {
                glass[cow[i]] = i;
            }
            queue.add(parent[cow[i]].next);
            bfs(i);
            // System.out.println(Arrays.toString(Arrays.copyOf(glass, N + 1)));
        }
        System.out.println(Arrays.stream(glass).filter(i -> i >= K).count());
    }
 
    static void bfs(final int count) {
        while (!queue.isEmpty()) {
            Fild nextFild = queue.poll();
            while (nextFild != null) {
                if (glass[nextFild.index] == count - 1) {
                    glass[nextFild.index] = count;
                    queue.add(parent[nextFild.index].next);
                } else if (glass[nextFild.index] != count) {
                    queue.add(parent[nextFild.index].next);
                }
                nextFild = nextFild.next;
            }
        }
    }
 
    static class Fild {
        int     index;
        Fild    next;
 
        Fild(int i) {
            index = i;
        }
    }
}