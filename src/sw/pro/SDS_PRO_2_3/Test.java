package sw.pro.SDS_PRO_2_3;

public class Test {
    public static void main(String[] args)  {
        int[] start_int = new int[]{1, 5, 21, 85, 341};
        String[] start_string = new String[]{"1", "101", "10101", "1010101", "101010101"};

        int N = 1 << 7, M = 1 << 8;
        for (int start_n : start_int) {
            int index_n = start_n;
            while (index_n < N) {
                for (int start_m : start_int) {
                    int index_m = start_m;
                    while (index_m < M) {

                    }
                    index_m <<= 1;
                }
                index_n <<= 1;
            }
        }

//        int i, j, index;
//        for (i = 0; i <= 341; i++) {
//            for (j = 0; j <= 341; j++)
//                if (((i << 1) & j) == 0 && ((i >> 1) & j) == 0) {
//                    if (check11(i)) {
//                        System.out.print(Integer.toBinaryString(j) + "-" + j + " ");
//                    }
//                }
//            System.out.println();
//        }
//
//        Map<Integer, List<Integer>> data = new HashMap<>();
//        for (i = 0; i <= 341; i++) {
//            //index = 0;
//            for (j = 0; j <= 341; j++) {
//                if (Integer.bitCount(i) > 5 || Integer.bitCount(j) > 5) continue;
//                if (((i << 1) & j) == 0 && ((i >> 1) & j) == 0 && !check11(j)) {
//                    //index++;
//                    //System.out.println(Integer.toBinaryString(i << 1) + " " + Integer.toBinaryString(i >> 1) + " " + Integer.toBinaryString(j) + "-" + j + "   " + index);
//                    data.computeIfAbsent(i, v -> new ArrayList<Integer>(11)).add(j);
//                }
//            }
//            //System.out.println("-------------------------------------------------------");
//        }


//        i = Integer.valueOf("0101010101",2);
//        System.out.println(i);
//        j = Integer.valueOf("1100111011",2);
//        System.out.println(Integer.toBinaryString(i&j));
//        System.out.println(i&j);


    }

    static boolean check11(int n) {
        int i = n;
        while (i > 0) {
            if ((i & 1) == 1 && ((i >> 1) & 1) == 1) {
                return true;
            }
            i >>= 1;
        }
        return false;
    }
}
