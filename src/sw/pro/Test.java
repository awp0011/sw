package sw.pro;


public class Test {


    public static void main(String[] args) {
        int x = 131073,y = 171071;


        while (x <= y) {
            x = (x + 1) >> 1;
            y = (y - 1) >> 1;
            System.out.println(x+" "+y);
        }
    }

}