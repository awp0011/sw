package sw.pro.tree;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class Tree {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet<>(Integer::compareTo);
        TreeMap<Integer, Integer> map = new TreeMap<>(Integer::compareTo);
        int[] keys = new int[]{1, 4, 2, 5, 7, 3, 1};
        int[] values = new int[]{2, 3, 1, 5, 1, 4, 1};

        for (int i = 0; i < keys.length; i++) {
            set.add(keys[i]);
            map.put(keys[i], values[i]);
        }
        if (set.contains(1)) set.remove(1);
        for (int i : set) System.out.print(i + " ");
        System.out.println();

        if (map.containsKey(5)) map.remove(5);
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            Integer key = iter.next();
            Integer value = map.get(key);
            System.out.println("( " + key + " ," + value + " )");
        }

    }
}
