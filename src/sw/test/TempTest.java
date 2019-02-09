package sw.test;


class source {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.printf(rand_pi(5000000).substring(0,4)); //改变参数值
    }

    public static String rand_pi(int n) {
        int numInCircle = 0;
        double x, y;
        double pi;
        for (int i = 0; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if (x * x + y * y < 1) numInCircle++;
        }
        pi = (4.0 * numInCircle) / n;
        return pi+"";
    }

}