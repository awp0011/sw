package sw.prp.bast.practices.ex2;

import sw.prp.bast.practices.ex1.Test1;
import sw.prp.bast.practices.ex1.Test1_bp1;
import sw.prp.bast.practices.ex1.Test1_bp2;
import sw.prp.bast.practices.ex1.Test1_bp3;

public class Runner {
    public static void main(String[] args) throws Exception {
        String[] ar = new String[10];
        System.out.println("Test2:");
        for (int i = 0; i < 5; i++) {
            ar[0] = i + "";
            Test2.main(ar);
        }
        System.out.println("Test2_bp1:");
        for (int i = 0; i < 5; i++) {
            ar[0] = i + "";
            Test2_bp1.main(ar);
        }
        System.out.println("Test2_bp2:");
        for (int i = 0; i < 5; i++) {
            ar[0] = i + "";
            Test2_bp2.main(ar);
        }
    }
}
