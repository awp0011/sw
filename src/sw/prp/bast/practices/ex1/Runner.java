package sw.prp.bast.practices.ex1;

public class Runner {
    public static void main(String[] args) throws Exception {
        String[] ar = new String[10];
        System.out.println("Test1:");
        for (int i = 0; i < 10; i++) {
            ar[0] = i + "";
            Test1.main(ar);
        }
        System.out.println("Test1_bp1:");
        for (int i = 0; i < 10; i++) {
            ar[0] = i + "";
            Test1_bp1.main(ar);
        }
        System.out.println("Test1_bp2:");
        for (int i = 0; i < 10; i++) {
            ar[0] = i + "";
            Test1_bp2.main(ar);
        }
        System.out.println("Test1_bp3:");
        for (int i = 0; i < 10; i++) {
            ar[0] = i + "";
            Test1_bp3.main(ar);
        }
    }
}
