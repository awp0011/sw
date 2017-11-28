package sw.pro.NQUEEN;

public class Test {
    public static void main(String[] Args) {
        int N = 12;
        int upper = 1;
        upper = (upper << N) - 1;
        System.out.println(upper);
        System.out.println(Integer.toBinaryString(upper));
    }
}
