package sw.adv.find.max;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class source {
    private static int[] maxs = new int[1_000_005];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        maxs[0] = Integer.MIN_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(N*5);
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            maxs[i] = cur > maxs[i-1] ? cur : maxs[i-1];
            sb.append(maxs[i]).append(' ');
        }
        //System.out.println(Arrays.toString(Arrays.copyOfRange(maxs,1,N+1)));
        System.out.println(sb.toString().trim());

    }
}