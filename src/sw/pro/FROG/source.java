package sw.pro.FROG;import java.io.BufferedReader;import java.io.InputStreamReader;import java.util.Arrays;import java.util.Comparator;import java.util.StringTokenizer;public class source {    private static COO[] a = new COO[100003];    private static int[][] v = new int[100003][4];    public static void main(String[] args) throws Exception {        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        StringTokenizer st = new StringTokenizer(br.readLine());        int i, j;        int N = Integer.valueOf(st.nextToken());        int K = Integer.valueOf(st.nextToken());        char[] Jump = br.readLine().toCharArray();        for (i = 0; i < N; i++) {            st = new StringTokenizer(br.readLine());            a[i] = new COO();            a[i].x = Integer.parseInt(st.nextToken());            a[i].y = Integer.parseInt(st.nextToken());            a[i].num = i;            a[i].flag = 0;        }        for (i = 0; i < N; i++) for (j = 0; j < 4; j++) v[i][j] = i;        //sort(a, a+N, cmp1);//        private boolean cmp1(COO A, COO B){//            if(A.x + A.y != B.x + B.y) return A.x + A.y < B.x + B.y;//            return A.x < B.x;//        }        Arrays.sort(a, 0, N - 1, (o1, o2) -> {            if (o1.x + o1.y != o2.x + o2.y) {                return (o1.x + o1.y) - (o2.x + o2.y);            }            return o1.x - o2.x;        });        for (i = 0; i < N - 1; i++) if (a[i].x + a[i].y == a[i + 1].x + a[i + 1].y) v[a[i].num][1] = a[i + 1].num;        for (i = N - 1; i > 0; i--) if (a[i].x + a[i].y == a[i - 1].x + a[i - 1].y) v[a[i].num][2] = a[i - 1].num;//        sort(a, a+N, cmp2);//        private boolean cmp2(COO A, COO B){//            if(A.x - A.y != B.x - B.y) return A.x - A.y < B.x - B.y;//            return A.x < B.x;//        }        Arrays.sort(a, 0, N - 1, (o1, o2) -> {            if (o1.x - o1.y != o2.x - o2.y) {                return (o1.x - o1.y) - (o2.x - o2.y);            }            return o1.x - o2.x;        });        for (i = 0; i < N - 1; i++) if (a[i].x - a[i].y == a[i + 1].x - a[i + 1].y) v[a[i].num][0] = a[i + 1].num;        for (i = N - 1; i > 0; i--) if (a[i].x - a[i].y == a[i - 1].x - a[i - 1].y) v[a[i].num][3] = a[i - 1].num;        //sort(a, a+N, cmp);//        private boolean cmp(COO A, COO B){//            return A.num < B.num;//        }        Arrays.sort(a, 0, N - 1, Comparator.comparingInt(COO::getNum));        int now = 0;        for (i = 0; i < K; i++) {            now = f(now, Jump[i] - 'A');        }        System.out.println(a[now].x + " " + a[now].y);    }    private static class COO {        int x, y, num, flag;        int getNum() {            return num;        }    }    private static int f(int now, int jump) {        if (v[now][jump] == now) return now;        for (int i = v[now][jump]; ; i = v[i][jump]) {            if (a[i].flag != 1) {                a[now].flag = 1;                v[now][jump] = i;                v[i][3 - jump] = now;                return i;            }            if (v[i][jump] == i) break;        }        return now;    }}