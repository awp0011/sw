package sw.contest.vjudge.UVA658;

public class Test {
    public static void main(String[] args) {
        // ①判定某些位置是否为1，如判定2、4位置为1，则转化为判断x|0101是否等于x。
        int x1 = 0b1111;
        int x2 = 0b1011;
        System.out.println(x1 == (x1 | 0b0101));
        System.out.println(x2 == (x2 | 0b0101));

        int x3 = 15;
        int x4 = 11;
        int x5 = 5;
        System.out.println(x3 == (x3 | x5));
        System.out.println(x4 == (x4 | x5));
        //②判定某些位置是否为0，如判定2、4位置为0，则转化为判断x&1010是否等于x。
        x3 = 15;
        x4 = 0;
        x5 = 9;
        System.out.println(x3 == (x3 & x5));
        System.out.println(x4 == (x4 & x5));

        //③将某些位置转化为1，如2、4位置转化为1，则令x=x|0101。


        //④将某些位置转化为0，如2、4位置转化为0，则令x=x&1010。


    }

    private static class Path {
        final char PLUS = 43;//+加号
        final char MINUS = 45;//- 减号
        int time;
        int p1, p2;
        int r1, r2;

        Path(int t, String c, String r) {
            init(t, c, r);
        }

        void init(int t, String pattern1, String pattern2) {
            time = t;
            p1 = p2 = r1 = r2 = 0;
            for (int i = 0; i < pattern1.length(); i++) {
                if (PLUS == pattern1.charAt(i)) {
                    p1 = (p1 << 1) + 1;
                    p2 = (p2 << 1) + 1;
                } else if (MINUS == pattern1.charAt(i)) {
                    p1 = (p1 << 1);
                    p2 = (p2 << 1);
                } else {
                    p1 = (p1 << 1);
                    p2 = (p2 << 1) + 1;
                }
                if (PLUS == pattern2.charAt(i)) {
                    r1 = (r1 << 1) + 1;
                    r2 = (r2 << 1) + 1;
                } else if (MINUS == pattern2.charAt(i)) {
                    r1 = (r1 << 1);
                    r2 = (r2 << 1);
                } else {
                    r1 = (r1 << 1);
                    r2 = (r2 << 1) + 1;
                }
            }
        }

        boolean isMatch(int t) {
            return (t == (t | p1)) && (t == (t & p2));
        }

        int doPath(int t) {
            return ((t | r1) & r2);
        }
    }
}
