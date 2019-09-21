package sw.pro;


public class Test {


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        char[] a = new char[]{'a', 'b', 'c', 'd', 'e'};
        sb.append(a);
        sb.setLength(3);
        sb.append(a);
        System.out.println(sb.toString());
    }

}