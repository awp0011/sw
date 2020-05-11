package sw.pro;

import java.util.HashSet;

public class Test {
        public static void main(String[] args) throws Exception {
            HashSet<int[]> set = new HashSet<>();
            set.add(new int[]{1,2});
            set.add(new int[]{1,2});
            System.out.println(set.size());
        }
    }

