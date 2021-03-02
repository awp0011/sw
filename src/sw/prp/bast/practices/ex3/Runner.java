package sw.prp.bast.practices.ex3;

import sw.prp.bast.practices.ex1.Test1;
import sw.prp.bast.practices.ex1.Test1_bp1;
import sw.prp.bast.practices.ex1.Test1_bp2;
import sw.prp.bast.practices.ex1.Test1_bp3;

public class Runner {
    public static void main(String[] args) throws Exception {
        String[] ar = new String[10];




        System.out.println("Test3_MergeSort:");
        for (int i = 0; i < 20; i++) {
            ar[0] = i + "";
            Test3_MergeSort.main(ar);
        }

        System.out.println("Test3_TimSort:");
        for (int i = 0; i < 20; i++) {
            ar[0] = i + "";
            Test3_TimSort.main(ar);
        }

    }
}
