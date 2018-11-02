package sw.pro.armyline;

public class BuildMaxCase {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            System.out.print("10000 ");
        }
        System.out.println();
        System.out.println(Integer.MAX_VALUE%100_000_007);
    }
}
