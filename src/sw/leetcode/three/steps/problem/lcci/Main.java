package sw.leetcode.three.steps.problem.lcci;

public class Main {
    private static final int mod = 1000000007;
    private static final int[] f = new int[1000005];
    private static final int[] steps = new int[4];

    public static void main(String[] args) {
        System.out.println(waysToStep1(5));
        System.out.println(waysToStep1(4));
        System.out.println(waysToStep1(20));

        System.out.println(waysToStep2(5));
        System.out.println(waysToStep2(4));
        System.out.println(waysToStep2(20));
    }

    private static int waysToStep1(int n) {
        f[0] = 1;
        for(int i = 1; i <= n; i++) {
            f[i] = f[i-1];
            if(i >= 2) f[i] = (f[i] + f[i-2]) % mod;
            if(i >= 3) f[i] = (f[i] + f[i-3]) % mod;
        }
        return f[n];
    }

    private static int waysToStep2(int n) {
        steps[1] = 1;
        steps[2] = 2;
        steps[3] = 4;
        if(n<4)return steps[n];
        for(int i=4;i<=n;i++){
            int cur = i%4;
            steps[cur] =  steps[((cur+4)-1)%4];
            steps[cur] += steps[((cur+4)-2)%4];
            steps[cur] %= mod;
            steps[cur] += steps[((cur+4)-3)%4];
            steps[cur] %= mod;
        }
        return steps[n%4];
    }
}


