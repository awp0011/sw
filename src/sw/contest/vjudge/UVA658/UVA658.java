package sw.contest.vjudge.UVA658;

public class UVA658 {
    public static void main(String[] args) {
/*
* 3 3
1 000 00-
1 00- 0-+
2 0-- -++
4 1
7 0-0+ ----
0 0
*/
        Path p1 = new Path(1, "000", "00-");
        Path p2 = new Path(1, "00-", "0-+");
        Path p3 = new Path(1, "0--", "-++");
        int i = 7;
        System.out.println(i + ":" + p1.isMatch(i) + ", Path:" + Integer.toBinaryString(i = p1.doPath(i)));
        System.out.println(i + ":" + p2.isMatch(i) + ", Path:" + Integer.toBinaryString(i = p2.doPath(i)));
        System.out.println(i + ":" + p1.isMatch(i) + ", Path:" + Integer.toBinaryString(i = p1.doPath(i)));
        System.out.println(i + ":" + p3.isMatch(i) + ", Path:" + Integer.toBinaryString(i = p3.doPath(i)));
        System.out.println(i + ":" + p1.isMatch(i) + ", Path:" + Integer.toBinaryString(i = p1.doPath(i)));
        System.out.println(i + ":" + p2.isMatch(i) + ", Path:" + Integer.toBinaryString(i = p2.doPath(i)));
        System.out.println(i + ":" + p1.isMatch(i) + ", Path:" + Integer.toBinaryString(p1.doPath(i)));

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
