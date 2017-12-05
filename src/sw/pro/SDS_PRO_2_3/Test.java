package sw.pro.SDS_PRO_2_3;

public class Test {
    public static void main(String[] args) throws Exception {
        int i, j;
//        for (i=0;i<=341;i++) {
//            for (j = 0; j <=341; j++)
//                if (((i << 1) & j) == 0 && ((i >> 1) & j) == 0) System.out.print(j + " ");
//            System.out.println();
//        }

        for (i = 0; i <= 341; i++) {
            for (j = 0; j <= 341; j++) {
                if (Integer.bitCount(i) > 5 || Integer.bitCount(j) > 5) continue;
                if (((i << 1) & j) == 0 && ((i >> 1) & j) == 0)
                    System.out.println(Integer.toBinaryString(i << 1) + " " + Integer.toBinaryString(i >> 1) + " " + Integer.toBinaryString(j)+"-"+j);
            }
            System.out.println("-------------------------------------------------------");
        }

//        i = Integer.valueOf("0101010101",2);
//        System.out.println(i);
//        j = Integer.valueOf("1100111011",2);
//        System.out.println(Integer.toBinaryString(i&j));
//        System.out.println(i&j);


    }
}
